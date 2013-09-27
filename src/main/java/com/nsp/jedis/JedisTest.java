package com.nsp.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class JedisTest {
	
	public void testJedis() {
		Jedis jedis = new Jedis("");
		
		jedis.watch("test1", "test2");
		Transaction transaction = jedis.multi();
		jedis.sadd("1", "123");
		transaction.sadd("2", "2");
		
		Response<Long> reponseOne = transaction.sadd("test1", "test1");
		Response<Long> reponseTwo = transaction.sadd("test2", "test2");
		transaction.exec();
		
		Long resultOne = reponseOne.get();
		Long resultTwo = reponseTwo.get();
	}

}
