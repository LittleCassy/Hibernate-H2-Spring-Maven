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
public class SubjectController {
	
	@Autowired
	private SubjectServiceImpl subjectService;
	
	@Autowired
	private StudentServiceImpl userService;
	
	@GetMapping("/centro/asignaturas")
	public List<SubjectModel> findAll() {
		List<StudentModel> myStudentList = userService.findAll();
		List<SubjectModel> mySubjectList = subjectService.findAll();
		updateSubjects();
		return mySubjectList;
	}
	
	public void updateSubjects() {
		List<StudentModel> myStudentList = userService.findAll();
		List<SubjectModel> mySubjectList = subjectService.findAll();
		
		for (SubjectModel subjectModel : mySubjectList) {
			int aux = 0;
			ArrayList<Integer> matriculatedStudents = new ArrayList<>();
			
			for (StudentModel studentModel : myStudentList) {
				if(studentModel.getMatriculatedSubjects().contains(subjectModel.getId())) {
					aux++;
					matriculatedStudents.add(studentModel.getId());
				}
			}
			
			subjectModel.setStudentsMatriculated(aux);
			subjectModel.setStudentsMatriculatedList(matriculatedStudents);
			subjectService.update(subjectModel);
		}
	}
	
	@GetMapping("/centro/asignaturas/{id}")
	public SubjectModel getUser(@PathVariable int id) {
		SubjectModel user = subjectService.findById(id);
		updateSubjects();
		return user;
	}
	
	@PostMapping("/centro/asignaturas/new")
	public SubjectModel addUser(@RequestBody SubjectModel subject) {
		updateSubjects();
		subjectService.save(subject);
		return subject;
	}
	
	@PutMapping("/centro/asignaturas/update")
	public SubjectModel updateUser(@RequestBody SubjectModel user) {
		updateSubjects();
		subjectService.update(user);
		return user;
	}
	
	@DeleteMapping("/centro/asignaturas/{id}")
	public String deleteUser(@PathVariable int id) {
		SubjectModel user = subjectService.findById(id);
		subjectService.deleteById(id);
		return "Deleted user id - " + id;
	}
}
