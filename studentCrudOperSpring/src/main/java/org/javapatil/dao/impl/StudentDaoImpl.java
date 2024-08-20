package org.javapatil.dao.impl;

import java.util.List;

import org.javapatil.dao.StudentDao;
import org.javapatil.extrator.StudentBySnoExtrator;
import org.javapatil.extrator.StudentListExtrator;
import org.javapatil.model.StudentForm;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StudentDaoImpl  implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	private StudentListExtrator studentListExtrator;
	private StudentBySnoExtrator studentBySnoExtrator;
	@Override
	public List<StudentForm> getStudList() {
		List<StudentForm> studList=jdbcTemplate.query("select * from student", studentListExtrator::extractData);
		return studList;
	}
	@Override
	public void insertStud(StudentForm studentForm) {
		String query="Insert into student values("+studentForm.getSno()+",'"+studentForm.getSname()+"',"+studentForm.getAge()+")";
		jdbcTemplate.update(query);
		
	}
	
	@Override
	public StudentForm getStudBySno(int sno) {
	
		StudentForm studentForm=jdbcTemplate.query("select * from student where sno="+sno, studentBySnoExtrator::extractData);
		return studentForm;
	}

}
