package com.nsp.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import static  org.junit.Assert.*;

public class NumberUtilsTest 
{
	@Test
	public void testNull() 
	{
		NumberUtils.isNumber(null);
		assertEquals(false, NumberUtils.isNumber(null));
		assertEquals(false, NumberUtils.isNumber(""));
		assertEquals(false, NumberUtils.isNumber("  "));
		
		Map<String, Object> testMap = new HashMap<String, Object>();
		testMap.put("1", new Date());
		testMap.put("2", "3");
		testMap.put("2", "3");
		
		System.out.println(testMap.toString());
		
	}
}
