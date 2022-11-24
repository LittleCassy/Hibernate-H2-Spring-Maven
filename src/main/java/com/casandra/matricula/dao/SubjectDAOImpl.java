package com.casandra.matricula.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casandra.matricula.model.StudentModel;
import com.casandra.matricula.model.SubjectModel;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<SubjectModel> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<SubjectModel> theQuery = currentSession.createQuery("from SubjectModel ", SubjectModel.class);
		List<SubjectModel> subjects = theQuery.getResultList();
		return subjects;
	}

	@Override
	public SubjectModel findById(int id) {
		Session currentSesion = entityManager.unwrap(Session.class);
		SubjectModel subject = currentSesion.get(SubjectModel.class, id);
		return subject;
	}

	@Transactional
	@Override
	public void save(SubjectModel subject) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(subject);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<SubjectModel> theQuery = currentSession.createQuery("delete from SubjectModel where id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
	}

	@Transactional
	@Override
	public void update(SubjectModel subject) {
		Session curreSession = entityManager.unwrap(Session.class);
		curreSession.merge(subject);
	}

}
