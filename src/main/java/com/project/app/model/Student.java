package com.project.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is required")
	    @Size(min = 3, message = "Name must be at least 3 characters")
	    private String name;

	    @NotNull(message = "Age is required")
	    @Min(value = 5, message = "Age must be at least 5")
	    @Max(value = 25, message = "Age must be at most 25")
	    private Integer age;

	    @NotNull(message = "Marks1 is required")
	    @Min(value = 0, message = "Marks must be >= 0")
	    @Max(value = 100, message = "Marks must be <= 100")
	    private Integer marks1;

	    @NotNull(message = "Marks2 is required")
	    @Min(0) @Max(100)
	    private Integer marks2;

	    @NotNull(message = "Marks3 is required")
	    @Min(0) @Max(100)
	    private Integer marks3;

	    @NotNull(message = "Marks4 is required")
	    @Min(0) @Max(100)
	    private Integer marks4;

	    @NotNull(message = "Marks5 is required")
	    @Min(0) @Max(100)
	    private Integer marks5;

	    private double percentage;
	    private String division;
}
