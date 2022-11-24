package com.casandra.matricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casandra.matricula.dao.StudentDAOImpl;
import com.casandra.matricula.model.StudentModel;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAOImpl studentDAO;

	@Override
	public List<StudentModel> findAll() {
		List<StudentModel> listUsers = studentDAO.findAll();
		return listUsers;
	}

	@Override
	public StudentModel findById(int id) {
		StudentModel user = studentDAO.findById(id);
		return user;
	}

	@Override
	public void save(StudentModel student) {
		studentDAO.save(student);
	}
	
	@Override
	public void update(StudentModel student) {
		studentDAO.update(student);
	}

	@Override
	public void deleteById(int id) {
		studentDAO.deleteById(id);
	}
}
