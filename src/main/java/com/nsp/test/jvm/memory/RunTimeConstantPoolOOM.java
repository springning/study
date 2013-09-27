package com.nsp.test.jvm.memory;

import java.util.ArrayList;
import java.util.List;


/**
 * VM ARGS:-XX:PermSize=10m -XX:MaxPermSize=10m
 * @author ningsiping
 *
 */
public class RunTimeConstantPoolOOM 
{

	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		
		int i = 0;
		while (true) 
		{
			list.add(("" + i).intern());
		}
	}
}
