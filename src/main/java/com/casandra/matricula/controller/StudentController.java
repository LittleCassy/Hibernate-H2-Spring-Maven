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
	
	/*Este metodo se hara cuando por una peticion GET * (como indica la anotacion)
	 * se llame a la url  http://127.0.0.1:8080/api//users */
	
	@GetMapping("/users")
	public List<StudentModel> findAll() {
		return userService.findAll();
	}
	
	/*Este metodo se hara cuando por una peticion GET * (como indica la anotacion)
	 * se llame a la url + el id de un usuario http://127.0.0.1:8080/api//users/1*/
	
	@GetMapping("/users/{userId}")
	public StudentModel getUser(@PathVariable int userId) {
		StudentModel user = userService.findById(userId);
		return user;
	}
	
	/*Este metodo se hara cuando por una peticion POST * (como indica la anotacion)
	 * se llame a la url + el id de un usuario http://127.0.0.1:8080/api//users*/
	
	@PostMapping("/users")
	public StudentModel addUser(@RequestBody StudentModel user) {
		userService.save(user);
		return user;
	}
	
	/*Este metodo se hara cuando por una peticion PUT * (como indica la anotacion)
	 * se llame a la url + el id de un usuario http://127.0.0.1:8080/api//users*/
	
	@PutMapping("/users")
	public StudentModel updateUser(@RequestBody StudentModel user) {
		userService.update(user);
		return user;
	}
	
	/*Este metodo se hara cuando por una peticion DELETE * (como indica la anotacion)
	 * se llame a la url + el id de un usuario http://127.0.0.1:8080/api//users/1*/
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		StudentModel user = userService.findById(userId);
		userService.deleteById(userId);
		return "Deleted user id - " + userId;
	}
}
