package com.duyngoc.service;

import java.util.List;

import com.duyngoc.ui.Student;

public interface AppService {
	public boolean login(String username, String password);
	public List<Student> loadStudents();
	//public saveStudent(Student s);
	public void updateStudent(Student s);
	public void deleteStudent(Student s);
	public void addstudent(Student s);
	public void updateStudentAddress(Student s);
	public void addAddress(Student s);
}
