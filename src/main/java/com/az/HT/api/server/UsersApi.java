package com.az.HT.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az.HT.Entity.User;
import com.az.HT.Repository.UsersRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Endpoints for managing user authentication")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersApi {

	@Autowired
	UsersRepository userRespository;

	@PostMapping(value = "/login")
	@Operation(summary = "Login user", description = "Authenticate user with email and password")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "401", description = "Unauthorized") })
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<User> loginUser(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User credentials", required = true) @RequestBody() User user) {
		User existingUser = userRespository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (existingUser != null) {
			return ResponseEntity.ok(existingUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
}

/*
 * @GetMapping public List<User> users() { return (List<User>)
 * userRespository.findAll(); }
 */
