package org.javapatil.services;

import java.util.List;

import org.javapatil.model.StudentForm;

public interface StudentServices {
 List<StudentForm> getStudListService();
 
 void insertStudServices(StudentForm studentForm);
 
 StudentForm getStudBySnoService(int sno);
 
 void updateStudServices(StudentForm studentForm);
}
