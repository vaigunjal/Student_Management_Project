package com.project.app.serviceI;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.project.app.model.Student;

import jakarta.validation.Valid;

public interface StudentServiceI {

	
	 Student createStudent(@Valid Student student);
	 
	 List<Student> getAllStudents();
     
	 Student updateStudent(Long id, Student student);

	 void deleteStudent(Long id);

}
