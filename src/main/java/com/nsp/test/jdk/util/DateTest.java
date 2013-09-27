package com.nsp.test.jdk.util;

import java.text.DecimalFormat;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class DateTest 
{
	@Test
	public void testLongToHourMinuteSecond()
	{
		System.out.println(longToHourMinuteSecond(1L));
		System.out.println(longToHourMinuteSecond(10L));
		System.out.println(longToHourMinuteSecond(100L));
		System.out.println(longToHourMinuteSecond(1000L));
		System.out.println(longToHourMinuteSecond(3600L));
		System.out.println(longToHourMinuteSecond(3601L));
		System.out.println(longToHourMinuteSecond(4601L));
		System.out.println(longToHourMinuteSecond(36000L));
		System.out.println(longToHourMinuteSecond(40601L));
		System.out.println(longToHourMinuteSecond(360010L));
		
		System.out.println(longToHourMinuteSecond(4000601L));
	}
	
	private  String longToHourMinuteSecond(Long second) {
		Long hourLong = 0L;  
		Long minuteLong = 0L;  
		Long secondLong = 0L;  
        
        hourLong = second / 3600;
        minuteLong = (second - hourLong * 3600) / 60;
        secondLong = second - hourLong * 3600 - minuteLong * 60;
        
        DecimalFormat decimalFormat = new DecimalFormat("00");
        
		return decimalFormat.format(hourLong) + ":" + decimalFormat.format(minuteLong)
						+ ":" + decimalFormat.format(secondLong);
	}
}	
