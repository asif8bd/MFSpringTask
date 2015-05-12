package com.asif.student.controller;






import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.asif.student.model.Student;

public class StudentRepository implements StudentDAO {    
	List<Student> studentsList=new ArrayList<Student>();
    
    public StudentRepository() {
        super();
    }
      
    
    
    

	@Override
	public void create(String studentId, String studentName, String studentEmail) {
		Student student=new Student(studentId, studentName, studentEmail);
		studentsList.add(student);
	}

	

	@Override
	public List<Student> findAllStudents() {
		return studentsList;
	}

	@Override
	public void update(Integer index, String studentId, String studentName,
			String studentEmail) {
		studentsList.get(index).setStudentId(studentId);
		studentsList.get(index).setStudentName(studentName);
		studentsList.get(index).setStudentEmail(studentEmail);
	}
	@Override
	public void delete(Integer index) {
		studentsList.remove((int)index);
		

	}

}
