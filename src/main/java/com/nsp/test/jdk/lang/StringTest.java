package com.nsp.test.jdk.lang;


import java.util.regex.Pattern;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Splitter;

public class StringTest 
{
	private static final String OPERATOR_STRING_REG_EXP = "[\\+\\-\\*/\\)\\(]";
	
	private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_STRING_REG_EXP);
	
	@Test
	@Ignore
	public void testSplit()
	{
		String testStr = "(asd+bfe)/(123+456)-123*4";
		String splitStrArray[] = testStr.split(OPERATOR_STRING_REG_EXP);
		for (String string : splitStrArray) {
			System.out.println(string);
		}
		
		System.out.println("***************************************");
		Iterable<String> splitedStringIterable = Splitter.on(OPERATOR_PATTERN).omitEmptyStrings().split(testStr);
		for (String string : splitedStringIterable) {
			System.out.println(string);
		}
	}
	
	
	@Test
	public void testToCharArray()
	{
		String test = "宁思平a1";
		char[] charArray = test.toCharArray();
		
		for (char c : charArray) {
			System.out.println(c);
		}
	}
}
