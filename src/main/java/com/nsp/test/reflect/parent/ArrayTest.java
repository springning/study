package com.nsp.test.reflect.parent;

import java.lang.reflect.Array;

public class ArrayTest {
	
	public static void main(String[] args) {
		print(args);
		
		print("****************************");
		
		byte primitiveByteArray[] = new byte[10];
		Byte byteArray[] = new Byte[10];
		
		
		System.out.println(checkIsByteArray(primitiveByteArray));
		System.out.println(checkIsByteArray(byteArray));
	}
	
	public static void print(Object object) {
		Class<?> classType = object.getClass();
		if (classType.isArray()) {
			Class<?> compenentClassType = classType.getComponentType();
			System.out.println("Array of type:" + compenentClassType.getName());
			System.out.println("Length:" + Array.getLength(object));
		}
	}
	
	private static  boolean checkIsByteArray(Object resultBeforeCommand) {
		Class<?> objectClass = resultBeforeCommand.getClass();
		return objectClass.isArray()
					&& byte.class.isAssignableFrom(objectClass.getComponentType());
	} 

}
