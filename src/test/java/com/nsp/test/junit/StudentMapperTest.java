package com.nsp.test.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nsp.test.StudentEntity;
import com.nsp.test.StudentMapper;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/conf/applicationContext.xml","/conf/applicationContext_mvc.xml"})
public class StudentMapperTest {
      
    @Autowired  
    private StudentMapper studentMapper;  
      
    @Test  
    public void getStudentTest(){  
        StudentEntity entity = studentMapper.getStudent("123456");  
        System.out.println(entity);  
          
          
    }  
}
