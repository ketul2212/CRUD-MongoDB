package com.ketul.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ketul.demo.crudService.CrudService;
import com.ketul.demo.exception.UserNotFoundException;
import com.ketul.demo.module.User;
import com.ketul.demo.module.dto.UserDto;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CrudService crudService;

	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@RequestBody UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		return crudService.save(user);
	}
		
	@GetMapping("/users")
	public List<User> getAll() {
		return crudService.getAll();
	}
	
	@GetMapping("/user/{id}")
	public User findOne(@PathVariable long id) {
	
		User user = crudService.getOne(id);
		
		if(user == null)
			throw new UserNotFoundException("ID :- " + id + " not found");
		
		return user;
	}
	
	@PutMapping("/user/{id}")
	public User update(@PathVariable long id, @RequestBody UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		return crudService.update(id, user);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable long id) {
		crudService.deleteById(id);
	}
}
