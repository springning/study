package com.nsp.test.jdk.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nsp.test.StudentEntity;

public class ListTest 
{
	
	@Test
	public void testModify() 
	{
		List<StudentEntity> studentEntityList = new ArrayList<StudentEntity>();
		
		StudentEntity studentEntityOne = new StudentEntity();
		studentEntityOne.setClassId("1");
		studentEntityList.add(studentEntityOne);
		
		StudentEntity studentEntityTwo = new StudentEntity();
		studentEntityTwo.setClassId("2");
		studentEntityList.add(studentEntityTwo);
		
		StudentEntity studentEntityThree = new StudentEntity();
		studentEntityThree.setClassId("3");
		studentEntityList.add(studentEntityThree);
		
		int i = 3;
		for (StudentEntity studentEntity : studentEntityList) {
			
			studentEntity.setClassId("" + (++i));
		}
		
		for (StudentEntity studentEntity : studentEntityList) {
			System.out.println(studentEntity.getClassId());
		}
	}
	

}
