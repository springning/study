package com.nsp.test.jvm.memory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;


/**
 * VM ARGS:-Xmx20m -XX:MaxDirectMemorySize=10m
 * @author ningsiping
 *
 */
public class DirectMemoryOOM 
{
	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException 
	{
//		Field unsafeField 
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		
		while (true) 
		{
			unsafe.allocateMemory(_1MB);
		}
	}

}
