package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer>{

}
