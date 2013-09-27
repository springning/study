package com.nsp.test.fanxing;

import org.junit.Test;

public enum TestEnumMethod 
{
	SAMPLE1
	{
		String getInfo() 
		{
			return "sample1";
		}
	},
	SAMPLE2 
	{
		String getInfo() 
		{
			return "sample2";
		}
	};
	
	abstract String getInfo();
	
	@Test
	public void testMethod() {
		for (TestEnumMethod testEnumMethod : TestEnumMethod.values()) {
			System.out.println(testEnumMethod.getInfo());
		}
	}
}
