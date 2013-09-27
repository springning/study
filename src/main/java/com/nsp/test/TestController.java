package com.nsp.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController 
{
	@Autowired
	private StudentMapper studentMapper;
	
	@RequestMapping(value="test.do")
	public void indexPage()
	{
		StudentEntity entity = studentMapper.getStudent("123456"); 
		System.out.println("name：" + entity.getStudentName());
	}
}
