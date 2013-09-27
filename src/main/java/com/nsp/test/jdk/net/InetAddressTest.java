package com.nsp.test.jdk.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class InetAddressTest 
{
	@Test
	public void testGetHostName()
	{
		try 
		{
			InetAddress inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress.getCanonicalHostName());
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
	}
}
