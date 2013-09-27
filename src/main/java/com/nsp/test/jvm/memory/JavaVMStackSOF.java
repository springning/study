package com.nsp.test.jvm.memory;

/**
 * VM Args:-Xss128k
 * @author ningsiping
 *
 */
public class JavaVMStackSOF 
{
	private int stackLength = 1;
	
	public void stackLeak() 
	{
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Exception 
	{
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
		
		try 
		{
			javaVMStackSOF.stackLeak();
		} 
		catch (Exception e) 
		{
//			System.out.println("stack length:" + javaVMStackSOF.stackLength);
			throw e;
		}
		finally
		{
			System.out.println("stack length:" + javaVMStackSOF.stackLength);
		}
		
	}

}
