package com.nexos.backend.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.beans.GenericMessageVO;
import com.nexos.backend.api.beans.UserAuthenticationVO;
import com.nexos.backend.api.beans.UserRecoveryVO;
import com.nexos.backend.api.beans.UserVO;
import com.nexos.backend.api.dao.PersonaDAO;
import com.nexos.backend.api.dao.RolDAO;
import com.nexos.backend.api.dao.UsuarioDAO;
import com.nexos.backend.api.dao.UsuarioRolDAO;
import com.nexos.backend.api.exception.UserNotFoundException;
import com.nexos.backend.api.model.Persona;
import com.nexos.backend.api.model.Rol;
import com.nexos.backend.api.model.Usuario;
import com.nexos.backend.api.model.UsuarioRol;

@Service
public class SecurityService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PersonaDAO personaDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@Autowired
	private UsuarioRolDAO usuarioRolDAO; 
	
	public UserVO authenticate(UserAuthenticationVO userAuthenticationVO) {
		List<Usuario> result = usuarioDAO.findByNombreUsuarioAndClave(userAuthenticationVO.getUserName(), userAuthenticationVO.getPassword());
		Usuario usuario = !result.isEmpty() ? result.get(0) : null;
		
		if(usuario == null) {
			throw new UserNotFoundException("Usuario no encontrado o clave invalida");
		}
		
		Persona persona = personaDAO.findById(usuario.getIdPersona()).get();
		
		UsuarioRol usuarioRol = usuarioRolDAO.findByIdUsuario(usuario.getIdUsuario()).get(0);
		
		Rol rol = rolDAO.findById(usuarioRol.getIdRol()).get();
		
		return new UserVO(usuario.getNombreUsuario(), usuario.getCorreoElectronico(), 
				persona.getPrimerNombre() + persona.getPrimerApellido(), rol.getRol());
	}
	public GenericMessageVO recovery(UserRecoveryVO userRecoveryVO) {
		Usuario usuario = usuarioDAO.findByNombreUsuario(userRecoveryVO.getUserName());
		if(usuario == null) {
			throw new UserNotFoundException("Usuario no encontrado");
		}
		return new GenericMessageVO("Fue enviado un correo electronico con la clave a " + usuario.getCorreoElectronico());
	}
}
