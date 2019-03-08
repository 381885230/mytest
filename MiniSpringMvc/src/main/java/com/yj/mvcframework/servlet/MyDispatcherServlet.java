package com.yj.mvcframework.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
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
	private Properties properties=new Properties();
	
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
		doScanner(properties.getProperty(SCANPATH));
		
		//3.初始化所有相关的实例，并保存到ioc容器
		doInstance();
		
		//4.依赖注入
		doAutowired();
		
		//5.构造handlerMapping
		initHandlerMapping();
		
		//6.等待请求，匹配url，定位方法，反射调用执行
		//调用doGet或doPost方法
		
		//提示信息
		System.out.println("===============my mini spring is init===============");
		
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
			
			for(Method method:methods){
				//没加MyRequestMapping注解的忽略
				if(!method.isAnnotationPresent(MyRequestMapping.class)){
					continue;
				}
				//映射url
				MyRequestMapping myrequestmapping=method.getAnnotation(MyRequestMapping.class);
				String url=("/"+baseUrl+"/"+myrequestmapping.value()).replaceAll("/+", "/");
				handlerMapping.put(url, method);
				System.out.println("mapped:"+url+"==="+method);
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
					beanName=field.getType().getSimpleName();//与放入ioc容器对应
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
						ioc.put(inf.getSimpleName(), clazz.newInstance());//与从ioc容器取值对应
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
			properties.load(ins);
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
//		this.doPostForTestClientInfo(req, resp);
//		this.doPostForClientHeader(req, resp);
//		this.doPostForTest_getParameterMap(req, resp);
		this.doPost(req, resp);
	}
	

	/**
     * 1.获得客户机信息
     */
	
/*	　		getRequestURL方法返回客户端发出请求时的完整URL。
	　　getRequestURI方法返回请求行中的资源名部分。
	　　getQueryString 方法返回请求行中的参数部分。
	　　getPathInfo方法返回请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以“/”开头。
	　　getRemoteAddr方法返回发出请求的客户机的IP地址。
	　　getRemoteHost方法返回发出请求的客户机的完整主机名。
	　　getRemotePort方法返回客户机所使用的网络端口号。
	　　getLocalAddr方法返回WEB服务器的IP地址。
	　　getLocalName方法返回WEB服务器的主机名。	*/
	protected void doPostForTestClientInfo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
		        String requestUri = request.getRequestURI();//得到请求的资源
		        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
		        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
		        String remoteHost = request.getRemoteHost();//返回发出请求的客户机的完整主机名
		        int remotePort = request.getRemotePort();//返回客户机所使用的网络端口号
		        String remoteUser = request.getRemoteUser();
		        String method = request.getMethod();//得到请求URL地址时使用的方法
		        String pathInfo = request.getPathInfo();
		        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
		        String localName = request.getLocalName();//获取WEB服务器的主机名
		        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
		        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		        response.setHeader("content-type", "text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.write("获取到的客户机信息如下：");
		        out.write("<hr/>");
		        out.write("请求的URL地址："+requestUrl);
		        out.write("<br/>");
		        out.write("请求的资源："+requestUri);
		        out.write("<br/>");
		        out.write("请求的URL地址中附带的参数："+queryString);
		        out.write("<br/>");
		        out.write("来访者的IP地址："+remoteAddr);
		        out.write("<br/>");
		        out.write("来访者的主机名："+remoteHost);
		        out.write("<br/>");
		        out.write("使用的端口号："+remotePort);
		        out.write("<br/>");
		        out.write("remoteUser："+remoteUser);
		        out.write("<br/>");
		        out.write("请求使用的方法："+method);
		        out.write("<br/>");
		        out.write("pathInfo："+pathInfo);
		        out.write("<br/>");
		        out.write("localAddr："+localAddr);
		        out.write("<br/>");
		        out.write("localName："+localName);
	}
	
/*	2.2、获得客户机请求头
	　　getHeader(string name)方法:String 
	　　getHeaders(String name)方法:Enumeration 
	　　getHeaderNames()方法*/
	protected void doPostForClientHeader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");// 设置将字符以"UTF-8"编码输出到客户端浏览器
		// 通过设置响应头控制浏览器以UTF-8的编码显示数据
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> reqHeadInfos = request.getHeaderNames();// 获取所有的请求头
		out.write("获取到的客户端所有的请求头信息如下：");
		out.write("<hr/>");
		while (reqHeadInfos.hasMoreElements()) {
			String headName = (String) reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);// 根据请求头的名字获取对应的请求头的值
			out.write(headName + ":" + headValue);
			out.write("<br/>");
		}
		out.write("<br/>");
		out.write("获取到的客户端Accept-Encoding请求头的值：");
		out.write("<hr/>");
		String value = request.getHeader("Accept-Encoding");// 获取Accept-Encoding请求头对应的值
		out.write(value);

		Enumeration<String> e = request.getHeaders("Accept-Encoding");
		while (e.hasMoreElements()) {
			String string = (String) e.nextElement();
			System.out.println(string);
		}
	}
	
	
/*	
 * 获得客户机请求参数(客户端提交的数据)
	getParameter(String)方法(常用--获取单个参数时)
	getParameterValues(String name)方法(常用--获取多个参数时)
	getParameterNames()方法(不常用)
	getParameterMap()方法(编写框架时常用)
	*/
	protected void doPostForTest_getParameterMap(HttpServletRequest request, HttpServletResponse response){
		//request对象封装的参数是以Map的形式存储的
        Map<String, String[]> paramMap = request.getParameterMap();
        for(Map.Entry<String, String[]> entry :paramMap.entrySet()){
            String paramName = entry.getKey();
            String paramValue = "";
            String[] paramValueArr = entry.getValue();
            for (int i = 0; paramValueArr!=null && i < paramValueArr.length; i++) {
                if (i == paramValueArr.length-1) {
                    paramValue+=paramValueArr[i];
                }else {
                    paramValue+=paramValueArr[i]+",";
                }
            }
            System.out.println(MessageFormat.format("{0}={1}", paramName,paramValue));
        }		
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
		
		//参数转存为list便于按类型取值
		List<Object> paramList=new ArrayList<Object>();
		
		//保存参数值
		Object[] paramValues=new Object[parameterTypes.length];
		//方法的参数列表
		for(int i=0;i<parameterTypes.length;i++){
			//根据参数名称做处理
			Class paramType=parameterTypes[i];
			if(paramType==HttpServletRequest.class){
				//参数类型明确的，强转
				paramValues[i]=req;
				paramList.add(paramValues[i]);
				continue;
			}else if(paramType==HttpServletResponse.class){
				paramValues[i]=resp;
				paramList.add(paramValues[i]);
				continue;				
			}else{
				for(Entry<String, String[]> param:parameterMap.entrySet()){
					Integer value=Integer.parseInt(Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ","));
					paramValues[i]=value;
					paramList.add(value);
				}	
				break;				
			}
		}
		
		Object[] paramValuesForMethod=new Object[parameterTypes.length];
		for(int i=0;i<paramList.size();i++){
			Class paramType=parameterTypes[i];
			if(paramType==HttpServletRequest.class){
				//参数类型明确的，强转
				paramValuesForMethod[i]=req;
				continue;
			}else if(paramType==HttpServletResponse.class){
				paramValuesForMethod[i]=resp;
				continue;				
			}else if(paramType==String.class){
					paramValuesForMethod[i]=(String)paramList.get(i);
			}else if(paramType==Integer.class){
				paramValuesForMethod[i]=(Integer)paramList.get(i);
			}			
		}
		
		try {
			String beanName=lowerFirstCase(method.getDeclaringClass().getSimpleName());//????
			//反射机制调用
			method.invoke(ioc.get(beanName), paramValuesForMethod);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * 原来的doDispatch方法有问题，当有多个同类型参数时，后一个的值会覆盖前一个，本人已改进
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void doDispatchOriginal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
				//此处同类型的参数值会覆盖
				for(Entry<String, String[]> param:parameterMap.entrySet()){
					String value=Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
					paramValues[i]=value;
				}
			}else if(paramType==Integer.class){
				//此处同类型的参数值会覆盖
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
