package com.nexos.backend.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Persona;

@Repository
public interface PersonaDAO extends CrudRepository<Persona, Long>{

}
