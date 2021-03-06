package com.learn.lock.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

	private static Map<String, Object> cache = new HashMap<String, Object>();

	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public Object getData(String key) {
		// 当线程开始读时，首先开始加上读锁
		rwl.readLock().lock();
		Object value = null;
		try {
			value = cache.get(key);
			// 判断是否存在值
			if (value == null) {
				// 在开始写之前，首先要释放读锁，否则写锁无法拿到
				rwl.readLock().unlock();
				// 获取写锁开始写数据
				rwl.writeLock().lock();
				try {
					// 再次判断该值是否为空，因为如果两个写线程都阻塞在这里，
					// 当一个线程被唤醒后value的值为null则进行数据加载，当另外一个线程也被唤醒如果不判断就会执行两次写
					if (value == null) {
						value = ""; // query 数据库
						cache.put(key, value);
					}
				} finally {
					rwl.writeLock().unlock(); // 释放写锁
				}
				rwl.readLock().lock(); // 写完之后降级为读锁
			}
		} finally {
			rwl.readLock().unlock(); // 释放读锁
		}

		return value;
	}

}