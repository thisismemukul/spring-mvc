package com.springmvc.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	private UserDaoService service;
	public UserResource(UserDaoService service) {
		this.service=service;
	}
	//GET/users
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return service.findAll();
	}
	//GET/users/:id
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id:"+id);
		return user;
	}
	//DELETE/users/:id
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id) {
		 service.deleteById(id);
		}
	//POST/users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveUser = service.save(user);
		//users/4 => /users /{id}, user.getID
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
