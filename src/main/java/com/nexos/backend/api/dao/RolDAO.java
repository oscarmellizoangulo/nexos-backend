package com.nexos.backend.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Rol;

@Repository
public interface RolDAO extends CrudRepository<Rol, Long>{

}
