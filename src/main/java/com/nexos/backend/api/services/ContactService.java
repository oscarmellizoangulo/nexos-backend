package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Contact;
import com.nexos.backend.api.repository.ContactRepository;
import com.nexos.backend.api.vo.ContactVO;

@Service
public class ContactService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ContactRepository contactRepository;
	
	public List<ContactVO> findAll() throws NexosServiceException{
		try {
			List<ContactVO> contactVOs = new ArrayList<>();
			contactRepository.findAll().forEach((contact) -> {
				contactVOs.add(modelMapper.map(contact, ContactVO.class));
			});
			return contactVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_CONTACT_ERROR, e);
		}
	}
	
	public ContactVO findById(Integer id) throws NexosServiceException {
		try {
			Contact contact = contactRepository.findById(id).get();
			return modelMapper.map(contact, ContactVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_CONTACT_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			contactRepository.delete(contactRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_CONTACT_ERROR, e);
		}
	}

	public ContactVO create(ContactVO contactVO) throws NexosServiceException {
		try {
			Contact contact = contactRepository.save(modelMapper.map(contactVO, Contact.class));
			return modelMapper.map(contact, ContactVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_CONTACT_ERROR, e);
		}
	}
}
