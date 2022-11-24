package com.casandra.matricula.model;

import java.util.ArrayList;
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
	private int studentsMatriculated;
	@Column
	private ArrayList<Integer> studentsMatriculatedList;
	
	public SubjectModel() {

	}

	public SubjectModel(int id, String name, int studentsMatriculated, ArrayList<Integer> studentsMatriculatedList) {
		this.id = id;
		this.name = name;
		this.studentsMatriculated = studentsMatriculated;
		this.studentsMatriculatedList = studentsMatriculatedList;
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

	public int getStudentsMatriculated() {
		return studentsMatriculated;
	}

	public void setStudentsMatriculated(int studentsMatriculated) {
		this.studentsMatriculated = studentsMatriculated;
	}

	public ArrayList<Integer> getStudentsMatriculatedList() {
		return studentsMatriculatedList;
	}

	public void setStudentsMatriculatedList(ArrayList<Integer> studentsMatriculatedList) {
		this.studentsMatriculatedList = studentsMatriculatedList;
	}
}
