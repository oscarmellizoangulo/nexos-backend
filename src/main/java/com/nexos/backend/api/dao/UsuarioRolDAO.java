package com.nexos.backend.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.UsuarioRol;

@Repository
public interface UsuarioRolDAO extends CrudRepository<UsuarioRol, Long>{
	public List<UsuarioRol> findByIdUsuario(Long idUsuario);
}
