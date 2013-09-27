package com.nsp.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringUtilsTest 
{
	@Test
	public void testJoin() 
	{
		List<String> stringList = new ArrayList<String>();
		assertEquals("", StringUtils.join(stringList, ","));
		
		stringList.add("123");
		assertEquals("123", StringUtils.join(stringList, ","));
		
		stringList.add("456");
		assertEquals("123,456", StringUtils.join(stringList, ","));
	}
}
