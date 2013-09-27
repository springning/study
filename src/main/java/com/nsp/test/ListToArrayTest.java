package com.nsp.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class ListToArrayTest {
	
	public static void main(String[] args) {
		List<String> test = new ArrayList<String>();
		test.add("1");
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("3");
		
		String[] strArray = new String[test.size()];
		test.toArray(strArray);
		
		
		for (String str : strArray) {
			System.out.println(str);
		}
		
		System.out.println("*****************************************");
		Set<String> set = new LinkedHashSet<String>(test);
		for (String str : set) {
			System.out.println(str);
		}
		
		System.out.println(StringUtils.join(set, ","));
		
		System.out.println(System.currentTimeMillis());
		
	}

}
