package com.nsp.test.jdk.lang;

import org.junit.Test;

public class StringBufferTest 
{
	@Test
	public void testDelete() 
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		System.out.println(stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length()));
		stringBuffer.append("123456");
		System.out.println(stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length()));
	}
}
