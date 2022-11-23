package com.casandra.matricula.service;

import java.util.List;

import com.casandra.matricula.model.StudentModel;

public interface StudentService {
	public List<StudentModel> findAll();
	
	public StudentModel findById(int id);
	
	public void save(StudentModel student);
	
	public void deleteById(int id);

	public void update(StudentModel student);
}
