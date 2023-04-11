package com.az.HT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class HtApplication {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(HtApplication.class, args);
	}

	/*
	 * public void run(String... args) throws Exception { String sql =
	 * "INSERT INTO services (service_id, service_name, service_status, service_status_description, service_category) VALUES (?, ?, ?, ?, ?)"
	 * ;
	 * 
	 * int result = jdbcTemplate.update(sql, 3421, "Luis", "luisarf222@gmail.com",
	 * "safsaf", "mal");
	 * 
	 * if (result > 0) { System.out.println("A new row has been inserted."); }
	 * 
	 * }
	 */
}
