package org.javapatil.dao;

import java.util.List;

import org.javapatil.model.StudentForm;

public interface StudentDao {
  List<StudentForm> getStudList();
  
  void insertStud(StudentForm studentForm);
  
  StudentForm getStudBySno(int sno);
  
  void updateStud(StudentForm studentForm);
  
  void deleteStud(int sno);
}
