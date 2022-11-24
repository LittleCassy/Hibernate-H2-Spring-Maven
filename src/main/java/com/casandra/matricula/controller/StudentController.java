package com.casandra.matricula.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casandra.matricula.model.StudentModel;
import com.casandra.matricula.model.SubjectModel;
import com.casandra.matricula.service.StudentServiceImpl;
import com.casandra.matricula.service.SubjectServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private SubjectServiceImpl subjectService;
	
	@Autowired
	private StudentServiceImpl userService;
	
	@GetMapping("/centro/alumnos")
	public List<StudentModel> findAll() {
		
		return userService.findAll();
	}
	
	@GetMapping("/centro/alumnos/{userId}")
	public StudentModel getUser(@PathVariable int userId) {
		StudentModel user = userService.findById(userId);
		return user;
	}
	
	@PostMapping("/centro/alumnos/new")
	public StudentModel addUser(@RequestBody StudentModel user) {
		userService.save(user);
		return user;
	}
	
	@PutMapping("/centro/alumnos/update")
	public StudentModel updateUser(@RequestBody StudentModel user) {
		userService.update(user);
		return user;
	}
	
	@PutMapping("/centro/matricular/{id_alumno}/{id_asignatura}")
	public String matriculateUser(@PathVariable int id_alumno,@PathVariable int id_asignatura) {
		StudentModel student = userService.findById(id_alumno);
		student.getMatriculatedSubjects().add(id_asignatura);
	    userService.update(student);
	    SubjectModel mySubject = subjectService.findById(id_asignatura);
	    mySubject.setStudentsMatriculated(mySubject.getStudentsMatriculated()+1);
	    mySubject.getStudentsMatriculatedList().add(id_alumno);
	    subjectService.update(mySubject);
	    return "Added subject " + id_asignatura + " to student - " + id_alumno;
	}
	
	@DeleteMapping("/centro/matricular/{id_alumno}/{id_asignatura}")
	public String dematriculateUser(@PathVariable int id_alumno,@PathVariable int id_asignatura) {
		StudentModel student = userService.findById(id_alumno);
		for (int i = 0; i < student.getMatriculatedSubjects().size(); i++) {
			if(student.getMatriculatedSubjects().get(i)==id_asignatura) {
				student.getMatriculatedSubjects().remove(i);
				break;
			}
		}
		SubjectModel mySubject = subjectService.findById(id_asignatura);
	    mySubject.setStudentsMatriculated(mySubject.getStudentsMatriculated()-1);
	    for (int i = 0; i < mySubject.getStudentsMatriculatedList().size(); i++) {
			if(mySubject.getStudentsMatriculatedList().get(i)==id_alumno) {
				mySubject.getStudentsMatriculatedList().remove(i);
			}
		}
	    subjectService.update(mySubject);
	    userService.update(student);
	    return "Removed subject " + id_asignatura + " to student - " + id_alumno;
	}
	
	@DeleteMapping("/centro/alumnos/{userId}")
	public String deleteUser(@PathVariable int userId) {
		StudentModel user = userService.findById(userId);
		userService.deleteById(userId);
		return "Deleted user id - " + userId;
	}
}
