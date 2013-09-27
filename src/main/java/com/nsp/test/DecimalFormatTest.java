package com.nsp.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.Test;

public class DecimalFormatTest 
{
	@Test
	public void testOne()
	{
		DecimalFormat decimal = new DecimalFormat("0.00%");
		decimal.setMaximumFractionDigits(2);
		decimal.setRoundingMode(RoundingMode.HALF_UP);
		
		System.out.println(decimal.format(2.0/3));
		System.out.println(decimal.format(0.0/3));
		System.out.println(decimal.format(2/3));
		
		System.out.println(decimal.format(new BigDecimal("2.0").divide(new BigDecimal("3"), RoundingMode.HALF_UP)));
		
		
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		System.out.println(decimalFormat.format(0));
		System.out.println(decimalFormat.format(0.0));
		System.out.println("******************************************");
		
		
		decimalFormat = new DecimalFormat("#,###.##");
		System.out.println(decimalFormat.format(0));
		System.out.println(decimalFormat.format(0.0));
		System.out.println("******************************************");
	}
	
}	
