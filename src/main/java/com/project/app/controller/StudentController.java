package com.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.Student;
import com.project.app.service.StudentServiceImpl;
import com.project.app.service.UserService;
import com.project.app.serviceI.StudentServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	
	@Autowired
	private StudentServiceI studentServiceI;
	
	// CREATE Student
	@PostMapping
	public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
	    Student savedStudent = studentServiceI.createStudent(student);
	    return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	 
	//GET ALL Student
	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
	    return new ResponseEntity<>(studentServiceI.getAllStudents(), HttpStatus.OK);
	}

    //  UPDATE Student
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id,
	                                      @Valid @RequestBody Student student) {
	    Student updatedStudent = studentServiceI.updateStudent(id, student);
	    return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}

    //  DELETE Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        studentServiceI.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
	  

}
