package com.project.app.service;

import java.util.List;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.Student;
import com.project.app.repository.StudentRepository;
import com.project.app.serviceI.StudentServiceI;

import jakarta.validation.Valid;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(@Valid Student student) 
	{
		  calculateResult(student);
		return studentRepository.save(student);
	}

	 private void calculateResult(Student student) {

	        double total = student.getMarks1()
	                + student.getMarks2()
	                + student.getMarks3()
	                + student.getMarks4()
	                + student.getMarks5();

	        double percentage = total / 5.0;

	        student.setPercentage(percentage);

	        // Division logic
	        if (percentage >= 60) {
	            student.setDivision("First Division");
	        } else if (percentage >= 50) {
	            student.setDivision("Second Division");
	        } else {
	            student.setDivision("Fail");
	        }
	    }
	

	

	
	    // ✅ GET ALL
	    @Override
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    // ✅ UPDATE
	    @Override
	    public Student updateStudent(Long id, Student student) {

	        Student existingStudent = studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

	        existingStudent.setName(student.getName());
	        existingStudent.setAge(student.getAge());

	        existingStudent.setMarks1(student.getMarks1());
	        existingStudent.setMarks2(student.getMarks2());
	        existingStudent.setMarks3(student.getMarks3());
	        existingStudent.setMarks4(student.getMarks4());
	        existingStudent.setMarks5(student.getMarks5());
	        // ✅ 1. Recalculate percentage
	        double percentage = (existingStudent.getMarks1() +
	                             existingStudent.getMarks2() +
	                             existingStudent.getMarks3() +
	                             existingStudent.getMarks4() +
	                             existingStudent.getMarks5()) / 5.0;

	        // ✅ 2. Recalculate division
	        String division;
	        if (percentage >= 60) {
	            division = "First Division";
	        } else if (percentage >= 50) {
	            division = "Second Division";
	        } else {
	            division = "Fail";
	        }

	        // ✅ 3. Set updated values
	        existingStudent.setPercentage(percentage);
	        existingStudent.setDivision(division);
	        
	        return studentRepository.save(existingStudent);
	    }

	    // ✅ DELETE
	    @Override
	    public void deleteStudent(Long id) {

	        if (!studentRepository.existsById(id)) {
	            throw new RuntimeException("Student not found with id: " + id);
	        }

	        studentRepository.deleteById(id);
	    }
	
	

}
