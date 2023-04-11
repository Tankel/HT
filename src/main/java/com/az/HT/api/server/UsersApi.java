package com.az.HT.api.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(value = "/login")
	public User login() {
		return new User("sbizley2@thetimes.co.uk", "f66i8rvW");
	}

	@GetMapping(value = "/login/status")
	public boolean loginStatus() {
		boolean exists = userRespository.existsUserByName(name);
		return
	}

	/*
	 * @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public String echo(@RequestBody User us) { return us.toString(); }
	 */
	/*
	 * @GetMapping(value = "/login") public User postBody(@RequestBody User us) {
	 * return new User("npadkin1@tumblr.com", "rGwsLf0Igb"); }
	 */
	/*
	 * @PostMapping public void insert(@RequestBody User us) {
	 * userRespository.save(us); }
	 * 
	 * @PutMapping public void modify(@RequestBody User us) {
	 * userRespository.save(us); }
	 */

	/*
	 * @DeleteMapping(value = "/{id}") public void delete(@PathVariable("id")
	 * Integer id) { userRespository.deleteById(id); }
	 */

	/*
	 * @GetMapping(value = "/login/{name}") public boolean
	 * exist(@PathVariable("name") String name) { boolean exists =
	 * userRespository.existsUserByName(name); return exists; }
	 */
}
