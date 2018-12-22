package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

}
