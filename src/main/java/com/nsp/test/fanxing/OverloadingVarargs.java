package com.nsp.test.fanxing;

import org.apache.commons.lang3.time.DateFormatUtils;

public class OverloadingVarargs {
	static void f(float i, Character... args) 
	{
		System.out.println("first");
	}

	static void f(Character... args) 
	{
		System.out.println("second");
	}

	public static void main(String[] args) 
	{
		f(1, 'a');
//		f('a', 'b');// Error
	}
}
