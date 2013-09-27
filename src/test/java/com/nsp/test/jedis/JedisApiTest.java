package com.nsp.test.jedis;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.Transaction;

public class JedisApiTest {
	
	public void testTransaction() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		Transaction transaction = jedis.multi();
	}
	
	@Test
	@Ignore
	public void testNormal1() {
		Jedis jedis = new Jedis("127.0.0.1");
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			String result = jedis.set("n" + i, "n" + i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Simple SET: " + ((end - start)/1000.0) + " seconds");
		 
		jedis.disconnect();
	}
	
	
	@Test
	@Ignore
	/**
	 * redis的事务保证,一个client发起的事务中的命令可以连续的执行,<p>
	 * 中间不会插入其他client的命令.事务中某个操作失败，并不会回滚其他操作
	 */
	public void test2Trans() {
		Jedis jedis = new Jedis("127.0.0.1");
		
		long start = System.currentTimeMillis();
		Transaction transaction = jedis.multi();
		for (int i = 0; i < 100000; i++) {
			transaction.set("t" + i, "t" + i);
		}
		List<Object> results = transaction.exec();
		long end = System.currentTimeMillis();
		System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
		
		jedis.disconnect();
	}
	
	@Test
	@Ignore
	public void test3Pipelined() {
		Jedis jedis = new Jedis("127.0.0.1");
		
		Pipeline pipeline = jedis.pipelined();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			pipeline.set("p" + i, "p" + i);
		}
		List<Object> result = pipeline.syncAndReturnAll();
		long end = System.currentTimeMillis();
	    System.out.println("Pipelined SET: " + ((end - start)/1000.0) + " seconds");
	    
	    jedis.disconnect();
	}
	
	@Test
	@Ignore
	public void test4combPipelineTrans() {
		Jedis jedis = new Jedis("127.0.0.1");
		
		long start = System.currentTimeMillis();
		Pipeline pipeline = jedis.pipelined();
		pipeline.multi();
		for (int i = 0; i < 100000; i++) {
	        pipeline.set("" + i, "" + i);
	    }
		pipeline.exec();
		List<Object> results = pipeline.syncAndReturnAll();
		long end = System.currentTimeMillis();
		System.out.println("Pipelined transaction: " + ((end - start)/1000.0) + " seconds");
		 
		jedis.disconnect();
	}
	
	
	@Test
	public void test5shardNormal() {
		List<JedisShardInfo> jedisShardInfoList = Arrays.asList(
				new JedisShardInfo("127.0.0.1", 6379), new JedisShardInfo(
						"127.0.0.1", 6380));
		
		ShardedJedis shardedJedis = new ShardedJedis(jedisShardInfoList);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
	        String result = shardedJedis.set("sn" + i, "n" + i);
	    }
	}
}
