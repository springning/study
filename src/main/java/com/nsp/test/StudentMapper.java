package com.nsp.test;

import java.util.List;

public interface StudentMapper {
	public StudentEntity getStudent(String studentID);

	public StudentEntity getStudentAndClass(String studentID);

	public List<StudentEntity> getStudentAll();

	public void insertStudent(StudentEntity entity);

	public void deleteStudent(StudentEntity entity);

	public void updateStudent(StudentEntity entity);
}
