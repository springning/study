package com.nsp.test.reflect.parent;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public class Child extends Parent{
	public static void main(String[] args) {
		Child child = new Child();
		child.test();
		
	}
	
	public void test() {
		Field field = ReflectionUtils.findField(super.getClass(), "test");
		field.setAccessible(true);
		String value = (String)ReflectionUtils.getField(field, this);
		
		System.out.println(value);
	}
}
