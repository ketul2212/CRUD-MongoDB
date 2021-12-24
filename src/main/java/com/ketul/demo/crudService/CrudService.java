package com.ketul.demo.crudService;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ketul.demo.Repo.UserRepo;
import com.ketul.demo.exception.UserNotFoundException;
import com.ketul.demo.module.User;

@Component
public class CrudService {
	@Autowired
	private UserRepo userRepo;
	
	public ResponseEntity<Object> save(User user) {
		
		List<User> list = userRepo.findAll();
		
		user.setId(list.get(list.size() - 1).getId() + 1);
//		System.out.println(user.getId());
		userRepo.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	public List<User> getAll() {
		
		return userRepo.findAll();
	}

	public User getOne(long id) {
		
		User user = userRepo.findById(id).orElse(null);
		return user;
	}

	public void deleteById(long id) {
		userRepo.deleteById(id);
		
	}

	public User update(long id, User user) {
		User findUser = userRepo.findById(id).orElse(null);
		
		if(findUser == null)
			throw new UserNotFoundException("ID :- " + id + " not found");
		
		findUser.setName(user.getName());
		findUser.setEmail(user.getEmail());
		
		return userRepo.save(findUser);
	}
}
