package com.az.HT.api.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az.HT.Entity.User;
import com.az.HT.Repository.UsersRepository;

@RestController
@RequestMapping("/api/user")
public class UsersApi {
	@Autowired
	UsersRepository userRespository;

	@GetMapping
	public List<User> users() {
		return (List<User>) userRespository.findAll();
	}

	@PostMapping(value = "/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		User existingUser = userRespository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (existingUser != null) {
			// return ResponseEntity.ok().build();
			return ResponseEntity.ok(existingUser);
		} else {
			// return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or
			// password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

}
