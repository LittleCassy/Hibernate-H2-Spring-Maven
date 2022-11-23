package com.casandra.matricula.dao;

import java.util.List;
import com.casandra.matricula.model.StudentModel;

public interface StudentDAO {

	public List<StudentModel> findAll();
	
	public StudentModel findById(int id);
	
	public void save(StudentModel user);
	
	public void deleteById(int id);

	public void update(StudentModel user);
}
