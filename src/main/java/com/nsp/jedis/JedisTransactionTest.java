package com.nsp.jedis;

import org.apache.commons.pool.impl.GenericObjectPool.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

public class JedisTransactionTest {
	public static JedisPool pool;
	static {
		pool = new JedisPool(new Config(), "127.0.0.1", 6379);
	}

	public static void main(String[] args) {
		Jedis jedis = pool.getResource();
		jedis.set("name", "songr");
		new ThreadClient3(pool).start(); // 模拟客户端1
		new ThreadClient4(pool).start(); // 模拟客户端2
		new ThreadClient5(pool).start(); // 获取对象
	}
}

class ThreadClient3 extends Thread {
	JedisPool pool;
	Jedis jedis;

	public ThreadClient3(JedisPool pool) {
		jedis = pool.getResource();
	}

	public void run() {
		if ("OK".equals(jedis.watch("name"))) {
			System.out.println("key:name 被监视");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Transaction t = jedis.multi();
		t.set("name", "songrt");
		if (t.exec() == null) {
			System.out.println("数据库中的name 已经被修改,ThreadClient3无法set  name");
		}
		jedis.unwatch();

	}
}

class ThreadClient4 extends Thread {
	JedisPool pool;
	Jedis jedis;

	public ThreadClient4(JedisPool pool) {
		jedis = pool.getResource();
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if ("OK".equals(jedis.set("name", "songru"))) {
			System.out.println("ThreadClient4 set name 成功");
		}
		// pool.returnResource(jedis);
	}
}

class ThreadClient5 extends Thread {
	JedisPool pool;
	Jedis jedis;

	public ThreadClient5(JedisPool pool) {
		jedis = pool.getResource();
	}

	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String name = jedis.get("name");
		System.out.println("ThreadClient5 获取name 的值为:" + name);
	}
}
