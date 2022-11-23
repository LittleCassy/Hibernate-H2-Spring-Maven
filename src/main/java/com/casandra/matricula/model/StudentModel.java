package com.casandra.matricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	@Column
	private String dni;
	@Column
	private int age;
	@Column
	private int[] subjects;

	public StudentModel() {
		
	}

	public StudentModel(int id, String name, String dni, int age, int[] subjects) {
		super();
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.age = age;
		this.subjects = subjects;
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

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dNI) {
		dni = dNI;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int[] getSubjects() {
		return subjects;
	}

	public void setSubjects(int[] subjects) {
		this.subjects = subjects;
	}
}
