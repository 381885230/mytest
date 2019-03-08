package com.learn.simpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 因为我们把SimpleDateFormat定义为静态变量，那么多线程下SimpleDateFormat的实例就会被多个线程共享，
 * B线程会读取到A线程的时间，就会出现时间差异和其它各种问题。SimpleDateFormat和它继承的DateFormat类也不是线程安全的
 * 
 * 解决方案：
 * 只在需要的时候创建新实例，不用static修饰
 * synchronized大法好
 * ThreadLocal
 * 文章：https://mp.weixin.qq.com/s/XeKdHWkdigrKsvmcOVe8Fg
 * @author yuanjin
 * @date 2019年3月8日 下午1:39:17
 */
public class SimpleDateFormatTest1 {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String formatDate(Date date) throws ParseException {
		return sdf.format(date);
	}

	public static Date parse(String strDate) throws ParseException {
		return sdf.parse(strDate);
	}

	public static void main(String[] args) throws InterruptedException, ParseException {
		ExecutorService service = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 20; i++) {
			service.execute(() -> {
				for (int j = 0; j < 10; j++) {
					try {
						System.out.println(parse("2018-01-02 09:45:59"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
		}
		// 等待上述的线程执行完
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
	}
	
	public static void singleThread(){
		System.out.println(sdf.format(new Date()));
	}
}