package com.nsp.test.jvm.memory;


/**
 * VM Args:-Xss2m
 * @author ningsiping
 *
 */
public class JavaVMStackOOM 
{
	private void dontStop()
	{
		while (true) 
		{
		}
	}
	
	public void stackLeakByThread()
	{
		while (true) 
		{
			Thread thread = new Thread(new Runnable() 
			{
				public void run() 
				{
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) 
	{
		JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
		//javaVMStackOOM.stackLeakByThread();该方法在本机不能运行
	}

}
