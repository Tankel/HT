package com.az.HT.api.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az.HT.Entity.Service;
import com.az.HT.Repository.ServicesStatusRepository;

@RestController
@RequestMapping("/api/services/status")
public class ServicesStatusApi {
	@Autowired
	ServicesStatusRepository serviceRespository;

	@GetMapping
	public List<Service> services() {
		return (List<Service>) serviceRespository.findAll();
	}

	/*
	 * @PostMapping public void insert(@RequestBody Service us) {
	 * serviceRespository.save(us); }
	 * 
	 * @PutMapping public void modify(@RequestBody Service us) {
	 * serviceRespository.save(us); }
	 */

	/*
	 * @DeleteMapping(value = "/{id}") public void delete(@PathVariable("id")
	 * Integer id) { serviceRespository.deleteById(id); }
	 */
}
