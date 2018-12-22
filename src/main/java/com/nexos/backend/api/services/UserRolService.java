package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.UserRol;
import com.nexos.backend.api.repository.UserRolRepository;
import com.nexos.backend.api.vo.UserRolVO;

@Service
public class UserRolService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private UserRolRepository userRolRepository;
	
	public List<UserRolVO> findAll() throws NexosServiceException{
		try {
			List<UserRolVO> userRolVOs = new ArrayList<>();
			userRolRepository.findAll().forEach((userRol) -> {
				userRolVOs.add(modelMapper.map(userRol, UserRolVO.class));
			});
			return userRolVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_USER_ERROR, e);
		}
	}
	
//	public UserRolVO findById(Integer id) throws NexosServiceException {
//		try {
//			UserRol userRol = userRolRepository.findById(id).get();
//			return modelMapper.map(userRol, UserRolVO.class);
//		}catch(Exception e) {
//			throw new NexosServiceException(MessageCode.FIND_USER_ERROR, e);
//		}
//	}
//	
//	public void deleteById(Integer id) throws NexosServiceException {
//		try {
//			userRolRepository.delete(userRolRepository.findById(id).get());
//		}catch(Exception e) {
//			throw new NexosServiceException(MessageCode.DELETE_USER_ERROR, e);
//		}
//	}

	public UserRolVO create(UserRolVO userRolVO) throws NexosServiceException {
		try {
			UserRol userRol = userRolRepository.save(modelMapper.map(userRolVO, UserRol.class));
			return modelMapper.map(userRol, UserRolVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_USER_ERROR, e);
		}
	}
}
