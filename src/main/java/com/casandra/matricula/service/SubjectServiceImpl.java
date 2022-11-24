package com.casandra.matricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casandra.matricula.dao.StudentDAOImpl;
import com.casandra.matricula.dao.SubjectDAOImpl;
import com.casandra.matricula.model.StudentModel;
import com.casandra.matricula.model.SubjectModel;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAOImpl subjectDAO;
	
	@Override
	public List<SubjectModel> findAll() {
		List<SubjectModel> listSubjects = subjectDAO.findAll();
		return listSubjects;
	}

	@Override
	public SubjectModel findById(int id) {
		SubjectModel user = subjectDAO.findById(id);
		return user;
	}

	@Override
	public void save(SubjectModel subject) {
		subjectDAO.save(subject);
	}

	@Override
	public void deleteById(int id) {
		subjectDAO.deleteById(id);
	}

	@Override
	public void update(SubjectModel subject) {
		subjectDAO.update(subject);
	}

}
