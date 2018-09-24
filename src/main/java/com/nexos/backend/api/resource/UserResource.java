package com.nexos.backend.api.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.backend.api.beans.User;
import com.nexos.backend.api.beans.UserAuthentication;
import com.nexos.backend.api.exception.BeanNotFoundException;

@RestController()
public class UserResource {
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Long id) {
		User user = new User();//studentRepository.findById(id);

		if (user == null)
			throw new BeanNotFoundException("User id-" + id);

		return user;
	}
	@PostMapping("/users/authentication")
	public User userAuthentication(@RequestBody UserAuthentication userAuthentication) {
		User user = new User(1, 1, "oscar", "pas", "mail");
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(user.getIdUser()).toUri();

		return user;//ResponseEntity.created(location).build();

	}
}
