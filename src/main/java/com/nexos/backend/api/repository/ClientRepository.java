package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

}
