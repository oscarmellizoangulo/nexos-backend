package com.nexos.backend.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRol, Long>{
	public List<UsuarioRol> findByIdUsuario(Long idUsuario);
}
