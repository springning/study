package com.nsp.test.jvm.memory;


/**
 * VM ARGS:-verbose:class -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * -XX:+TraceClassLoading
 * @author ningsiping
 *
 */
public class FinalizeEscapeGC 
{
	
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive()
	{
		System.out.println("Yes, i am still alive");
	}
	
	protected void finalize() throws Throwable 
	{
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		SAVE_HOOK = new FinalizeEscapeGC();
		
		SAVE_HOOK = null;
		System.gc();
		//因为Finalizer方法优先级低，暂停1秒，等待其执行完毕
		Thread.sleep(1000);
		if (null != SAVE_HOOK) 
		{
			SAVE_HOOK.isAlive();
		}
		else
		{
			System.out.println("no, i am dead:");
		}
		
		
		//下面的自救失败
		SAVE_HOOK = null;
		System.gc();
		//因为Finalizer方法优先级低，暂停1秒，等待其执行完毕
		Thread.sleep(1000);
		if (null != SAVE_HOOK) 
		{
			SAVE_HOOK.isAlive();
		}
		else
		{
			System.out.println("no, i am dead:");
		}
	}

}
