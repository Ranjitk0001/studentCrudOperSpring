package org.javapatil.services.imp;

import java.util.List;

import org.javapatil.dao.StudentDao;
import org.javapatil.model.StudentForm;
import org.javapatil.services.StudentServices;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServicesImpl implements StudentServices{
 private StudentDao studentDao;

@Override
public List<StudentForm> getStudListService() {
	List<StudentForm> studList=studentDao.getStudList();
	return studList;
}
 
 
}
