package com.nexos.backend.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.beans.GenericMessageVO;
import com.nexos.backend.api.beans.UserAuthenticationVO;
import com.nexos.backend.api.beans.UserRecoveryVO;
import com.nexos.backend.api.beans.UserVO;
import com.nexos.backend.api.exception.UserNotFoundException;
import com.nexos.backend.api.model.Persona;
import com.nexos.backend.api.model.Rol;
import com.nexos.backend.api.model.Usuario;
import com.nexos.backend.api.model.UsuarioRol;
import com.nexos.backend.api.repository.PersonaRepository;
import com.nexos.backend.api.repository.RolRepository;
import com.nexos.backend.api.repository.UsuarioRepository;
import com.nexos.backend.api.repository.UsuarioRolRepository;

@Service
public class SecurityService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private UsuarioRolRepository usuarioRolRepository; 
	
	public UserVO authenticate(UserAuthenticationVO userAuthenticationVO) {
		List<Usuario> result = usuarioRepository.findByNombreUsuarioAndClave(userAuthenticationVO.getUserName(), userAuthenticationVO.getPassword());
		Usuario usuario = !result.isEmpty() ? result.get(0) : null;
		
		if(usuario == null) {
			throw new UserNotFoundException("Usuario no encontrado o clave invalida");
		}
		
		Persona persona = personaRepository.findById(usuario.getIdPersona()).get();
		
		UsuarioRol usuarioRol = usuarioRolRepository.findByIdUsuario(usuario.getIdUsuario()).get(0);
		
		Rol rol = rolRepository.findById(usuarioRol.getIdRol()).get();
		
		return new UserVO(usuario.getNombreUsuario(), usuario.getCorreoElectronico(), 
				persona.getPrimerNombre() + persona.getPrimerApellido(), rol.getRol());
	}
	public GenericMessageVO recovery(UserRecoveryVO userRecoveryVO) {
		Usuario usuario = usuarioRepository.findByNombreUsuario(userRecoveryVO.getUserName());
		if(usuario == null) {
			throw new UserNotFoundException("Usuario no encontrado");
		}
		return new GenericMessageVO("Fue enviado un correo electronico con la clave a " + usuario.getCorreoElectronico());
	}
}
