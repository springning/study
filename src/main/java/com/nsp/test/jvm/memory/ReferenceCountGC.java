package com.nsp.test.jvm.memory;

/**
 * VM ARGS:-XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * @author ningsiping
 *
 */
public class ReferenceCountGC 
{
	public Object instance = null;
	
	private static final int _1MB = 1024*1024;
	
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void main(String[] args) throws InterruptedException 
	{
		ReferenceCountGC objA = new ReferenceCountGC();
		ReferenceCountGC objB = new ReferenceCountGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
		
		Thread.sleep(10000);
	}
}
