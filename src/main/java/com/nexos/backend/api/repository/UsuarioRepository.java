package com.nexos.backend.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	public List<Usuario> findByNombreUsuarioAndClave(String nombreUsuario, String clave);
	public Usuario findByNombreUsuario(String nombreUsuario);
}
