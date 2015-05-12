package com.asif.student.controller;




import com.asif.student.model.Student;

import java.util.List;

public interface StudentDAO {	


	public void create(String studentId,String studentName, String studentEmail);
	
	public List<Student> findAllStudents();
	
	public void update(Integer index, String studentId, String studentName, String studentEmail);
	public void delete(Integer index);
	
}