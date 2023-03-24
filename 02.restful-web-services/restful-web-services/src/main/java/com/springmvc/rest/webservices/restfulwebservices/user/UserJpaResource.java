package com.springmvc.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springmvc.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	private UserRepository repository;

	public UserJpaResource(UserRepository repository) {

		this.repository = repository;
	}

	// GET/users
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers() {
		return repository.findAll();
	}

	// http://localost:8080/users

	// EntityModel
	// WebMvcLinkBuilder

	// GET/users/:id
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	// DELETE/users/:id
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	// GET Post/users/:id/post
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id:" + id);
		return user.get().getPosts();
	}

	// POST/users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveUser = repository.save(user);
		// users/4 => /users /{id}, user.getID
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
