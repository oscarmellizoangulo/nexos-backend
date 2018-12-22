package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Person;
import com.nexos.backend.api.model.Person;
import com.nexos.backend.api.repository.PersonRepository;
import com.nexos.backend.api.vo.PersonVO;
import com.nexos.backend.api.vo.PersonVO;

@Service
public class PersonService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private PersonRepository personRepository;
	
	public List<PersonVO> findAll() throws NexosServiceException{
		try {
			List<PersonVO> personVOs = new ArrayList<>();
			personRepository.findAll().forEach((person) -> {
				personVOs.add(modelMapper.map(person, PersonVO.class));
			});
			return personVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_PERSON_ERROR, e);
		}
	}
	
	public PersonVO findById(Integer id) throws NexosServiceException {
		try {
			Person person = personRepository.findById(id).get();
			return modelMapper.map(person, PersonVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_PERSON_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			personRepository.delete(personRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_PERSON_ERROR, e);
		}
	}

	public PersonVO create(PersonVO personVO) throws NexosServiceException {
		try {
			Person person = personRepository.save(modelMapper.map(personVO, Person.class));
			return modelMapper.map(person, PersonVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_PERSON_ERROR, e);
		}
	}
}
