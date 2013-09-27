package com.nsp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestListToString 
{
	@Test
	public void testListToString() 
	{
		List<Object> objectList = new ArrayList<Object>();
		
		objectList.add("123");
		objectList.add("宁思平");
		
		System.out.println("test" + objectList);
	}
}
