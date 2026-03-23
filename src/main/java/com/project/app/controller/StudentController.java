package com.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	 @PostMapping
	    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
	        return ResponseEntity.ok(studentServiceI.createStudent(student));
	    }
	 

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentServiceI.getAllStudents());
    }

    // ✅ UPDATE Student
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id,
                                          @Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentServiceI.updateStudent(id, student));
    }

    // ✅ DELETE Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        studentServiceI.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
	  

}
