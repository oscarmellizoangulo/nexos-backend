package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{

}
