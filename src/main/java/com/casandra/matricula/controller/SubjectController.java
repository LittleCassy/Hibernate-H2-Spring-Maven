package com.casandra.matricula.controller;

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

import com.casandra.matricula.model.SubjectModel;
import com.casandra.matricula.service.SubjectServiceImpl;

@RestController
@RequestMapping("/api")
public class SubjectController {
	@Autowired
	private SubjectServiceImpl subjectService;
	
	@GetMapping("/centro/asignaturas")
	public List<SubjectModel> findAll() {
		return subjectService.findAll();
	}
	
	@GetMapping("/centro/asignaturas/{id}")
	public SubjectModel getUser(@PathVariable int userId) {
		SubjectModel user = subjectService.findById(userId);
		return user;
	}
	
	@PostMapping("/centro/asignaturas/new")
	public SubjectModel addUser(@RequestBody SubjectModel user) {
		subjectService.save(user);
		return user;
	}
	
	@PutMapping("/centro/asignaturas/update")
	public SubjectModel updateUser(@RequestBody SubjectModel user) {
		subjectService.update(user);
		return user;
	}
	
	@DeleteMapping("/centro/asignaturas/{id}")
	public String deleteUser(@PathVariable int userId) {
		SubjectModel user = subjectService.findById(userId);
		subjectService.deleteById(userId);
		return "Deleted user id - " + userId;
	}
}
