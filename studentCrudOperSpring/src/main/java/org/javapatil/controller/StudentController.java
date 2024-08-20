package org.javapatil.controller;

import java.util.List;

import org.javapatil.model.StudentForm;
import org.javapatil.services.StudentServices;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "studentlist")

public class StudentController {
	private StudentServices studentServices;

	@GetMapping
    public List<StudentForm>	getStudListCtrl(){
		List<StudentForm> studList=studentServices.getStudListService();
	 
	 return studList;
	}

}
