package com.nsp.test.common.collections;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.nsp.test.StudentEntity;


@SuppressWarnings("unchecked")
public class CollectionUtilsTest 
{
	
	
	@Test
	public void testCollectionUtils()
	{
		List<String> stringList = new ArrayList<String>();
		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		stringList.add("6");
		stringList.add("5");
		
		List<String> subStringList = new ArrayList<String>();
		subStringList.add("5");
		subStringList.add("6");
		subStringList.add("7");
		subStringList.add("8");
		subStringList.add("9");
		
		List<String> resultList = (List<String>)CollectionUtils.disjunction(stringList, subStringList);
		System.out.println(resultList);
		
		resultList = ((List<String>)CollectionUtils.subtract(stringList, subStringList));
		System.out.println(resultList);
		
		StudentEntity studentEntity = new StudentEntity();
		List<StudentEntity> testStudentEntityList = new ArrayList<StudentEntity>();
		
		studentEntity.setClassId("123");
		studentEntity.setStudentName("123");
		testStudentEntityList.add(studentEntity);
		
		studentEntity.setClassId("234");
		studentEntity.setStudentName("234");
		testStudentEntityList.add(studentEntity);
		
		System.out.println(testStudentEntityList.size());
		
		
		for (int i = 0; i < testStudentEntityList.size(); i++) {
			studentEntity = testStudentEntityList.get(i);
			System.out.println(studentEntity.getStudentName());
		}
	}

}
