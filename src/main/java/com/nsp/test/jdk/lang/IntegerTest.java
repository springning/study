package com.nsp.test.jdk.lang;

import org.junit.Test;

/**
 * 生产者模式
 * @author ningsiping
 *
 */
public class IntegerTest 
{
	@Test
	public void testMax()
	{
		int testMax = 2 * Integer.MAX_VALUE;
		System.out.println(testMax);
		
		System.out.println(Integer.MAX_VALUE - 1);
	}
}
