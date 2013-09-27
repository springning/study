package com.nsp.test.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xmx20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 * @author ningsiping
 *
 */
public class HeapOOM 
{
	
	static class OOMObject
	{
	}
	
	public static void main(String[] args) 
	{
		List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
		while (true) 
		{
			list.add(new OOMObject());
		}
	}
	
}
