package com.nexos.backend.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.backend.api.beans.UserVO;
import com.nexos.backend.api.beans.UserAuthenticationVO;
import com.nexos.backend.api.beans.UserRecoveryVO;
import com.nexos.backend.api.exception.BeanNotFoundException;
import com.nexos.backend.api.exception.UserNotFoundException;
import com.nexos.backend.api.services.SecurityService;

@RestController
@RequestMapping("/nexos-api/users")
public class UserResource {
	
	@Autowired
	private SecurityService securityService;
	
//	@GetMapping("/{id}")
//	public UserVO retrieveUser(@PathVariable Long id) {
//		UserVO userVO = new UserVO();//studentRepository.findById(id);
//
//		if (userVO == null)
//			throw new BeanNotFoundException("UserVO id-" + id);
//
//		return userVO;
//	}
	@PostMapping("/authentication")
	public ResponseEntity userAuthentication(@RequestBody UserAuthenticationVO userAuthenticationVO) {
		try {
			return ResponseEntity
		            .status(HttpStatus.OK)                 
		            .body(securityService.authenticate(userAuthenticationVO));
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	@PostMapping("/recovery")
	public ResponseEntity recovery(@RequestBody UserRecoveryVO userRecoveryVO) {
		try {
			return ResponseEntity
		            .status(HttpStatus.OK)                 
		            .body(securityService.recovery(userRecoveryVO));
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
}
