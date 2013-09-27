package com.nsp.test.math;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest 
{
	@Test
	public void testZero()
	{
		System.out.println((new BigDecimal("0")).compareTo(BigDecimal.ZERO));
		System.out.println((new BigDecimal("+0")).compareTo(BigDecimal.ZERO));
		System.out.println((new BigDecimal("-0")).compareTo(BigDecimal.ZERO));
		System.out.println((new BigDecimal("0.0")).compareTo(BigDecimal.ZERO));
		System.out.println((new BigDecimal("+0.0")).compareTo(BigDecimal.ZERO));
		System.out.println((new BigDecimal("-0.0")).compareTo(BigDecimal.ZERO));
	}
}
