package com.az.HT.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.az.HT.Entity.Service;

@Repository
public interface ServicesStatusRepository extends CrudRepository<Service, Integer> {

}
