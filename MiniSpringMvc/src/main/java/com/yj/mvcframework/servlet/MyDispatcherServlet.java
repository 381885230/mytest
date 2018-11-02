package com.yj.mvcframework.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yj.mvcframework.annotation.MyAutowired;
import com.yj.mvcframework.annotation.MyController;
import com.yj.mvcframework.annotation.MyRequestMapping;
import com.yj.mvcframework.annotation.MyService;

/**
 * 启动类，入口
 * @author admin
 *
 */
public class MyDispatcherServlet extends HttpServlet{
	//与web.xml中param-name配置一致
	private static final String LOCATION="contextConfigLocation";
	
	//扫描路径
	private static final String SCANPATH="scanPackage";
	
	//保存配置信息
	private Properties p=new Properties();
	
	//保存扫描到的类名
	private List<String> classNames=new ArrayList<String>();
	
	//IOC容器，保存初始化的bean
	private Map<String,Object> ioc=new HashMap<String,Object>();
	
	//保存所有的url和方法的映射关系
	private Map<String,Method> handlerMapping=new HashMap<String,Method>();
	
	
	

	public MyDispatcherServlet() {
		super();
	}

	/**
	 * 初始化，加载配置文件
	 */
	public void init(ServletConfig config)throws ServletException{
		//1.加载配置文件
		doLoadConfig(config.getInitParameter(LOCATION));
		
		//2.扫描所有相关的类
		doScanner(p.getProperty(SCANPATH));
		
		//3.初始化所有相关的实例，并保存到ioc容器
		doInstance();
		
		//4.依赖注入
		doAutowired();
		
		//5.构造handlerMapping
		initHandlerMapping();
		
		//6.等待请求，匹配url，定位方法，反射调用执行
		//调用doGet或doPost方法
		
		//提示信息
		System.out.println("my mini spring is init");
		
	}
	
	private void initHandlerMapping() {
		if(ioc.isEmpty()){
			return ;
		}
		
		for(Entry<String, Object> entry:ioc.entrySet()){
			Class<?> clazz=entry.getValue().getClass();
			if(!clazz.isAnnotationPresent(MyController.class)){
				continue;
			}
			
			String baseUrl="";
			//获取controller的url配置
			if(clazz.isAnnotationPresent(MyRequestMapping.class)){
				MyRequestMapping requestMapping=clazz.getAnnotation(MyRequestMapping.class);
				baseUrl=requestMapping.value();
			}
			
			//获取method的url配置
			Method[] methods=clazz.getMethods();
			
			for(Method m:methods){
				//没加MyRequestMapping注解的忽略
				if(!m.isAnnotationPresent(MyRequestMapping.class)){
					continue;
				}
				//映射url
				MyRequestMapping myrequestmapping=m.getAnnotation(MyRequestMapping.class);
				String url=("/"+baseUrl+"/"+myrequestmapping.value()).replaceAll("/+", "/");
				handlerMapping.put(url, m);
				System.out.println("mapped:"+url+","+m);
			}
		}
	}

	private void doAutowired() {
		if(ioc.isEmpty()){
			return ;
		}
		
		for(Entry<String, Object> entry:ioc.entrySet()){
			//拿到实例对象中的所有属性
			Field[] fields=entry.getValue().getClass().getDeclaredFields();
			for(Field field:fields){
				
				if(!field.isAnnotationPresent(MyAutowired.class)){
					continue;
				}
				
				MyAutowired autowired=field.getAnnotation(MyAutowired.class);
				String beanName=autowired.value().trim();
				if("".equals(beanName)){
					beanName=field.getType().getName();
				}
				//设置私有属性的访问权限
				field.setAccessible(true);
				try {
					field.set(entry.getValue(), ioc.get(beanName));
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				
			}
			
		}
	}

	private void doInstance() {
		if(classNames.size()==0){
			return ;
		}
		
		try {
			for(String className:classNames){
				Class<?> clazz=Class.forName(className);
				if(clazz.isAnnotationPresent(MyController.class)){
					//默认将首字母小写作为beanName
					String beanName=lowerFirstCase(clazz.getSimpleName());
					ioc.put(beanName, clazz.newInstance());
				}else if(clazz.isAnnotationPresent(MyService.class)){
					MyService service=clazz.getAnnotation(MyService.class);
					String beanName	= service.value();
					//设置了就用已设置的
					if(!"".equals(beanName.trim())){
						ioc.put(beanName, clazz.newInstance());
						continue;
					}
					//没设置就按接口类型创建一个实例
					Class<?>[] interfaces=clazz.getInterfaces();
					for(Class<?> inf:interfaces){
						ioc.put(inf.getName(), clazz.newInstance());
					}
					
				}else{
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doScanner(String packageName) {
		//将所有的包路径转换为文件路径
		URL url=this.getClass().getClassLoader().getResource("/"+packageName.replaceAll("\\.", "/"));	
		File dir=new File(url.getFile());
		for(File file:dir.listFiles()){
			//如果是文件夹则继续递归
			if(file.isDirectory()){
				doScanner(packageName+"."+file.getName());
			}else{
				classNames.add(packageName+"."+file.getName().replaceAll(".class", "").trim());
			}
		}
	}

	private void doLoadConfig(String location) {
		InputStream ins=null;
		try {
			ins=this.getClass().getClassLoader().getResourceAsStream(location);
			p.load(ins);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=ins){
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	
	/**
	 * 执行业务处理
	 */
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		try {
			doDispatch(req,resp);//匹配对应的方法
		} catch (Exception e) {
			//匹配过程中出现异常则打印异常信息
			e.printStackTrace();
			resp.getWriter().write("500 exception,details:\r\n"+Arrays.toString(e.getStackTrace()).
					replaceAll("\\[|\\]", "").replaceAll(".\\s", "\r\n"));
		}
	}
	
	private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(handlerMapping.isEmpty()){
			return;
		}
		String url=req.getRequestURI();
		String contextPath=req.getContextPath();
		url=url.replace(contextPath, "").replaceAll("/+", "/");
		
		if(!handlerMapping.containsKey(url)){
			resp.getWriter().write("404 not found");
		}
		
		Method method=handlerMapping.get(url);
		//获取方法的参数列表
		Class<?>[] parameterTypes=method.getParameterTypes();
		//获取请求的参数
		Map<String,String[]> parameterMap=req.getParameterMap();
		//保存参数值
		Object[] paramValues=new Object[parameterTypes.length];
		//方法的参数列表
		for(int i=0;i<parameterTypes.length;i++){
			//根据参数名称做处理
			Class paramType=parameterTypes[i];
			if(paramType==HttpServletRequest.class){
				//参数类型明确的，强转
				paramValues[i]=req;
				continue;
			}else if(paramType==HttpServletResponse.class){
				paramValues[i]=resp;
				continue;				
			}else if(paramType==String.class){
				for(Entry<String, String[]> param:parameterMap.entrySet()){
					String value=Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
					paramValues[i]=value;
				}
			}else if(paramType==Integer.class){
				for(Entry<String, String[]> param:parameterMap.entrySet()){
					Integer value=Integer.parseInt(Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ","));
					paramValues[i]=value;
				}				
			}
		}
		
		
		try {
			String beanName=lowerFirstCase(method.getDeclaringClass().getSimpleName());//????
			//反射机制调用
			method.invoke(ioc.get(beanName), paramValues);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * 首字母小写
	 * @param s
	 * @return
	 */
	private String lowerFirstCase(String s){
		char[] chars=s.toCharArray();
		chars[0]+=32;
		return String.valueOf(chars);
	}
}
