package com.nexos.backend.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.UserRol;
import com.nexos.backend.api.model.UserRolPK;

@Repository
public interface UserRolRepository extends CrudRepository<UserRol, UserRolPK>{

}
