package com.nsp.test.commons.lang;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class DateUtilsTest 
{
	@Test
	public void testAdd()
	{
		Date nowDate = new Date();
		System.out.println(DateFormatUtils.format(nowDate, "yyyy-MM-dd HH:mm:ss"));
		
		Date noHoursDate = DateUtils.truncate(nowDate, Calendar.DAY_OF_MONTH);
		Date startDate = DateUtils.addDays(noHoursDate, -30);
		System.out.println(DateFormatUtils.format(startDate, "yyyy-MM-dd HH:mm:ss"));
		
		System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(nowDate));
	}
}
