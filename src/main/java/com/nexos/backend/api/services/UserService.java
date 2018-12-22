package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.User;
import com.nexos.backend.api.repository.UserRepository;
import com.nexos.backend.api.vo.UserVO;

@Service
public class UserService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private UserRepository userRepository;
	
	public List<UserVO> findAll() throws NexosServiceException{
		try {
			List<UserVO> userVOs = new ArrayList<>();
			userRepository.findAll().forEach((user) -> {
				userVOs.add(modelMapper.map(user, UserVO.class));
			});
			return userVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_USER_ERROR, e);
		}
	}
	
	public UserVO findById(Integer id) throws NexosServiceException {
		try {
			User user = userRepository.findById(id).get();
			return modelMapper.map(user, UserVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_USER_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			userRepository.delete(userRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_USER_ERROR, e);
		}
	}

	public UserVO create(UserVO userVO) throws NexosServiceException {
		try {
			User user = userRepository.save(modelMapper.map(userVO, User.class));
			return modelMapper.map(user, UserVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_USER_ERROR, e);
		}
	}
}
