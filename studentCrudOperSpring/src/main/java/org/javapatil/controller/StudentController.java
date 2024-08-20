package org.javapatil.controller;

import java.util.List;

import org.javapatil.model.StudentForm;
import org.javapatil.services.StudentServices;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "students")
//Connect to Angular
@CrossOrigin("*")
public class StudentController {
	private StudentServices studentServices;

	@GetMapping
    public List<StudentForm>	getStudListCtrl(){
		List<StudentForm> studList=studentServices.getStudListService();
	 
	 return studList;
	}
	
	@PostMapping
	public void insertStudCtrl(@RequestBody StudentForm studentForm) {
		studentServices.insertStudServices(studentForm);
	}
	
	@GetMapping("/{snum}")
	public StudentForm getStudBySnoCtrl(@PathVariable(value = "snum") int sno) {
		StudentForm studentForm=studentServices.getStudBySnoService(sno);
		return studentForm;
	}

	@PutMapping
	public void updateStudCtrl(@RequestBody StudentForm studentForm) {
		studentServices.updateStudServices(studentForm);
	}
}
