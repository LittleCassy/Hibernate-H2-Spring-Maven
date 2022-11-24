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

import com.casandra.matricula.model.StudentModel;
import com.casandra.matricula.service.StudentServiceImpl;

@RestController
@RequestMapping("/api")

public class StudentController {
	
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
	
	@DeleteMapping("/centro/alumnos/{userId}")
	public String deleteUser(@PathVariable int userId) {
		StudentModel user = userService.findById(userId);
		userService.deleteById(userId);
		return "Deleted user id - " + userId;
	}
}
