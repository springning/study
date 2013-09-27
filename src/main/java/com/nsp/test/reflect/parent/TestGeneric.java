package com.nsp.test.reflect.parent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class TestGeneric<T> implements TestInterface<T> {
	
	private T object;
	
	public static void main(String[] args) {
		TestGeneric<String> testGeneric  = new TestGeneric<String>();
		Class classTest = testGeneric.test();
		
		System.out.println(testGeneric.getGenericClassType2().getName());
	}
	
	private Class<T> test ()
	{
		return getGenericClassType();
	}
	
	private Class<T> getGenericClassType() {
		Class<T> entityClass = null;
		Class<?> clazz = getClass(); //获取实际运行的类的 Class
        Type type = clazz.getGenericSuperclass(); //获取实际运行的类的直接超类的泛型类型
        if(type instanceof ParameterizedType){ //如果该泛型类型是参数化类型
            Type[] parameterizedType = ((ParameterizedType)type).getActualTypeArguments();//获取泛型类型的实际类型参数集
            entityClass = (Class<T>) parameterizedType[0]; //取出第一个(下标为0)参数的值
        }
		return entityClass;
	}
	
	private Class<T> getGenericClassType2() {
		return (Class<T>)object.getClass();
	}
}
