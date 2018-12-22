package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.PersonType;
import com.nexos.backend.api.model.PersonType;
import com.nexos.backend.api.repository.PersonTypeRepository;
import com.nexos.backend.api.vo.PersonTypeVO;
import com.nexos.backend.api.vo.PersonTypeVO;

@Service
public class PersonTypeService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private PersonTypeRepository personTypeRepository;
	
	public List<PersonTypeVO> findAll() throws NexosServiceException{
		try {
			List<PersonTypeVO> personTypeVOs = new ArrayList<>();
			personTypeRepository.findAll().forEach((personType) -> {
				personTypeVOs.add(modelMapper.map(personType, PersonTypeVO.class));
			});
			return personTypeVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_PERSONTYPE_ERROR, e);
		}
	}
	
	public PersonTypeVO findById(Integer id) throws NexosServiceException {
		try {
			PersonType personType = personTypeRepository.findById(id).get();
			return modelMapper.map(personType, PersonTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_PERSONTYPE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			personTypeRepository.delete(personTypeRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_PERSONTYPE_ERROR, e);
		}
	}

	public PersonTypeVO create(PersonTypeVO personTypeVO) throws NexosServiceException {
		try {
			PersonType personType = personTypeRepository.save(modelMapper.map(personTypeVO, PersonType.class));
			return modelMapper.map(personType, PersonTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_PERSONTYPE_ERROR, e);
		}
	}
}
