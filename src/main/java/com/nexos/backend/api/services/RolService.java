package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Rol;
import com.nexos.backend.api.repository.RolRepository;
import com.nexos.backend.api.vo.RolVO;

@Service
public class RolService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private RolRepository rolRepository;
	
	public List<RolVO> findAll() throws NexosServiceException{
		try {
			List<RolVO> rolVOs = new ArrayList<>();
			rolRepository.findAll().forEach((rol) -> {
				rolVOs.add(modelMapper.map(rol, RolVO.class));
			});
			return rolVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_ROL_ERROR, e);
		}
	}
	
	public RolVO findById(Integer id) throws NexosServiceException {
		try {
			Rol rol = rolRepository.findById(id).get();
			return modelMapper.map(rol, RolVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ROL_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			rolRepository.delete(rolRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_ROL_ERROR, e);
		}
	}

	public RolVO create(RolVO rolVO) throws NexosServiceException {
		try {
			Rol rol = rolRepository.save(modelMapper.map(rolVO, Rol.class));
			return modelMapper.map(rol, RolVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_ROL_ERROR, e);
		}
	}
}
