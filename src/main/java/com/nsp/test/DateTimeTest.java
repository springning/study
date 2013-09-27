package com.nsp.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date curDate = new Date();
		Date date = simpleDateFormat.parse("1970-01-01 08:00:00");
		
		System.out.println(simpleDateFormat.format(curDate));
		System.out.println(simpleDateFormat.format(date));
		
//		String test = "";
//		
//		Long testLong = Long.parseLong(test);
		
		System.out.println(1 ^ 1 + 1);
		
		BigDecimal bigDecimal = new BigDecimal("1.1111111111111111");
		
		System.out.println(bigDecimal.intValue() + "" + 1);
	}

}
