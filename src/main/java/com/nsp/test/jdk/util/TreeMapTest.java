package com.nsp.test.jdk.util;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class TreeMapTest 
{
	@Test
	public void testEqualsKey()
	{
		Map<String, String> map = new TreeMap<String, String>();
		map.put("0.3333", "3");
		map.put("0.1111", "4");
		map.put("0.3333", "2");
		map.put("0.1111", "5");
		System.out.println(map.size());
		
		Map<Object, String> bigDecimalMap = new TreeMap<Object, String>();
		bigDecimalMap.put(new BigDecimal("102"), "102");
		bigDecimalMap.put(new BigDecimal("20"), "20");
		bigDecimalMap.put(new BigDecimal("3"), "3");
		bigDecimalMap.put(new BigDecimal("1000"), "1000");
		
		
		System.out.println("----------------------------------------------");
		for (Map.Entry<Object, String> iterable_element : bigDecimalMap.entrySet()) {
			System.out.println(iterable_element.getValue());
		}
		System.out.println("----------------------------------------------");
		
//		NumberUtils.isNumber();
		
		System.out.println(NumberUtils.isNumber("a0.1111"));
		
		map = new LinkedHashMap<String, String>();
		map.put("0.3333", "3");
		map.put("0.1111", "4");
		map.put("0.3333", "2");
		map.put("0.1111", "5");
		System.out.println(map.size());
	}
	
	
	
}
