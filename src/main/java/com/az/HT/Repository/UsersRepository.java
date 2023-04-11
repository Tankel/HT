package com.az.HT.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.az.HT.Entity.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
	// List<User> findById(int user_id);
	boolean existsUserByName(String name);
}
