package org.javapatil.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.javapatil.model.StudentForm;
import org.javapatil.services.StudentServices;
import org.javapatil.util.security.admin.BaseResource;
import org.javapatil.util.security.admin.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/admin/students")
//Connect to Angular
@CrossOrigin("*")
public class StudentController extends BaseResource {
	private StudentServices studentServices;

	@GetMapping
    public List<StudentForm>	getStudListCtrl(@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		User user = getUser(request);

	     if(user==null) return null;

		
		List<StudentForm> studList=studentServices.getStudListService();
	 
	 return studList;
	}
	
	@PostMapping
	public void insertStudCtrl(@RequestBody StudentForm studentForm,@RequestHeader("access-token") String token, HttpServletRequest request) {
		User user = getUser(request);

	     if(user==null) return;
		
		studentServices.insertStudServices(studentForm);
	}
	
	@GetMapping("/{snum}")
	public StudentForm getStudBySnoCtrl(@PathVariable(value = "snum") int sno,@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		User user = getUser(request);

	     if(user==null) return null;
		
		StudentForm studentForm=studentServices.getStudBySnoService(sno);
		return studentForm;
	}

	@PutMapping
	public void updateStudCtrl(@RequestBody StudentForm studentForm,@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		User user = getUser(request);

	     if(user==null) return;
	     
		studentServices.updateStudServices(studentForm);
	}
	
	
	@DeleteMapping("/{snum}")
	public void deleteStudCtrl(@PathVariable(value = "snum") int sno ,@RequestHeader("access-token") String token, HttpServletRequest request)
	{ 
		User user = getUser(request);

	     if(user==null) return;
	     
		studentServices.deleteStudServices(sno);
	}
}
