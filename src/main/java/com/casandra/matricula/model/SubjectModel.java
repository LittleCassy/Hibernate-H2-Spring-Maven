package com.casandra.matricula.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SubjectModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String studentsMatriculated;
	@Column
	private List<Integer> matriculatedStudents;
	
	public SubjectModel() {

	}

	public SubjectModel(int id, String name, String studentsMatriculated, List<Integer> matriculatedStudents) {
		this.id = id;
		this.name = name;
		this.studentsMatriculated = studentsMatriculated;
		this.matriculatedStudents = matriculatedStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentsMatriculated() {
		return studentsMatriculated;
	}

	public void setStudentsMatriculated(String studentsMatriculated) {
		this.studentsMatriculated = studentsMatriculated;
	}

	public List<Integer> getMatriculatedStudents() {
		return matriculatedStudents;
	}

	public void setMatriculatedStudents(List<Integer> matriculatedStudents) {
		this.matriculatedStudents = matriculatedStudents;
	}
}
