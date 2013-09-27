package com.nsp.test;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StudentEntity implements Serializable 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public StudentEntity() 
	{
	}

	public StudentEntity(String studentID, String studentName,
			String studentSex, Date studentBirthday) {
		super();
		this.studentBirthday = studentBirthday;
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentSex = studentSex;
	}
	private Date studentBirthday;  
    private String studentID;  
    private String studentName;  
    private String studentSex; 
    private String classId;
    
	public Date getStudentBirthday() {
		return studentBirthday;
	}
	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public String toString() {
		return new ToStringBuilder(this).append("studentID", studentID)
						.append("studentBirthday", studentBirthday).build();
	}
}
