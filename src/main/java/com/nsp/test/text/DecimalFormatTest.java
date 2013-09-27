package com.nsp.test.text;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class DecimalFormatTest 
{
	public void TestOne() 
	{
		Locale[] locales = NumberFormat.getAvailableLocales();
		double myNumber = -1234.56;
		NumberFormat form;
		for (int j = 0; j < 4; ++j) {
			System.out.println("FORMAT");
			for (int i = 0; i < locales.length; ++i) {
				if (locales[i].getCountry().length() == 0) {
					continue; // Skip language-only locales
				}
				System.out.print(locales[i].getDisplayName());
				switch (j) {
				case 0:
					form = NumberFormat.getInstance(locales[i]);
					break;
				case 1:
					form = NumberFormat.getIntegerInstance(locales[i]);
					break;
				case 2:
					form = NumberFormat.getCurrencyInstance(locales[i]);
					break;
				default:
					form = NumberFormat.getPercentInstance(locales[i]);
					break;
				}
				if (form instanceof DecimalFormat) {
					System.out.print(": " + ((DecimalFormat) form).toPattern());
				}
				System.out.print(" -> " + form.format(myNumber));
				try {
					System.out.println(" -> "
							+ form.parse(form.format(myNumber)));
				} catch (ParseException e) {
				}
			}
		}
	}
	
	@Test
	public void testFormatObject()
	{
		DecimalFormat decimalFormat = new DecimalFormat("0.00%");
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		
		System.out.println(decimalFormat.format(NumberUtils.createNumber("0.1234567898")));
		
		
		decimalFormat.applyPattern("0");
		System.out.println(decimalFormat.format(NumberUtils.createNumber("1.1234567898")));
		System.out.println(decimalFormat.format(NumberUtils.createNumber("10.1234567898")));
		System.out.println(decimalFormat.format(NumberUtils.createNumber("123.1234567898")));
		System.out.println(decimalFormat.format(NumberUtils.createNumber("0.1234567898")));
		System.out.println(decimalFormat.format(NumberUtils.createNumber("123.6234567898")));
	}
}
