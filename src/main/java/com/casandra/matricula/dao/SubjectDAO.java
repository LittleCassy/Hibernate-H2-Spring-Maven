package com.casandra.matricula.dao;

import java.util.List;

import com.casandra.matricula.model.SubjectModel;

public interface SubjectDAO {
	
	public List<SubjectModel> findAll();
	
	public SubjectModel findById(int id);
	
	public void save(SubjectModel subject);
	
	public void deleteById(int id);

	public void update(SubjectModel subject);
}
