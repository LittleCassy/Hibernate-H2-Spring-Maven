package com.casandra.matricula.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.casandra.matricula.model.StudentModel;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<StudentModel> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		//TODO Change query
		Query<StudentModel> theQuery = currentSession.createQuery("from MyUser", StudentModel.class);
		
		List<StudentModel> students = theQuery.getResultList();
		return students;
	}

	@Override
	public StudentModel findById(int id) {
		Session currentSesion = entityManager.unwrap(Session.class);
		StudentModel user = currentSesion.get(StudentModel.class, id);
		
		return user;
	}

	@Transactional
	@Override
	public void save(StudentModel student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(student);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		//TODO Change query
		Session currentSession = entityManager.unwrap(Session.class);
		Query<StudentModel> theQuery = currentSession.createQuery("delete from MyUser where id=:idUser");
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
	}

	@Transactional
	@Override
	public void update(StudentModel student) {
		Session curreSession = entityManager.unwrap(Session.class);
		curreSession.merge(student);
	}

}
