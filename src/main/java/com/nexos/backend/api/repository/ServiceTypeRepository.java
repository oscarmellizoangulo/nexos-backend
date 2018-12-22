package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends CrudRepository<ServiceType, Integer>{

}
