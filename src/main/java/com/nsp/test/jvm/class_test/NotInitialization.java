package com.nsp.test.jvm.class_test;


/**
 * VM ARGS:-XX:+TraceClassLoading
 * @author ningsiping
 *
 */
public class NotInitialization 
{

	public static void main(String[] args) 
	{
		System.out.println(SubClass.value);
		
//		SuperClass[] superClassArray = new SubClass[10];
	}

}
