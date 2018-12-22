package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.exception.UserNotFoundException;
import com.nexos.backend.api.model.Rol;
import com.nexos.backend.api.model.User;
import com.nexos.backend.api.repository.PersonRepository;
import com.nexos.backend.api.repository.RolRepository;
import com.nexos.backend.api.repository.UserRepository;
import com.nexos.backend.api.vo.GenericMessageVO;
import com.nexos.backend.api.vo.RolVO;
import com.nexos.backend.api.vo.UserAuthenticationVO;
import com.nexos.backend.api.vo.UserRecoveryVO;
import com.nexos.backend.api.vo.UserVO;

@Service
public class SecurityService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserVO authenticate(UserAuthenticationVO userAuthenticationVO) throws NexosServiceException {
		List<User> result = userRepository.findByUserNameAndPassword(userAuthenticationVO.getUserName(), userAuthenticationVO.getPassword());
		User user = !result.isEmpty() ? result.get(0) : null;
		
		if(user == null) {
			throw new NexosServiceException(MessageCode.USER_NOT_FOUND_OR_INVALID_PASSWORD);
		}
		
		//Persona persona = personaRepository.findById(usuario.getIdPersona()).get();
		
		//UsuarioRol usuarioRol = usuarioRolRepository.findByIdUsuario(usuario.getIdUsuario()).get(0);
		
		List<Rol> roles = user.getRols(); //rolRepository.findById(usuarioRol.getIdRol()).get();
		
		List<RolVO> rolVOs = new ArrayList<>();
		for (Rol rol : roles) {
			rolVOs.add(new RolVO(rol.getIdRol(), rol.getRol()));
		}
		
		return new UserVO(user.getUserName(), user.getMail(), 
				user.getPerson().getFirstName() + user.getPerson().getLastName(), rolVOs);
	}
	public GenericMessageVO recovery(UserRecoveryVO userRecoveryVO) throws NexosServiceException {
		User user = userRepository.findByUserName(userRecoveryVO.getUserName());
		if(user == null) {
			throw new NexosServiceException(MessageCode.USER_NOT_FOUND);
		}
		return new GenericMessageVO(MessageCode.RECOVERY_PASSWORD_MESSAGE);
	}
}
