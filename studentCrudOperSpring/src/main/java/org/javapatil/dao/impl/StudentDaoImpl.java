package org.javapatil.dao.impl;

import java.util.List;

import org.javapatil.dao.StudentDao;
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
	@Override
	public List<StudentForm> getStudList() {
		List<StudentForm> studList=jdbcTemplate.query("select * from student", studentListExtrator::extractData);
		return studList;
	}
	

}
