package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.ContactType;
import com.nexos.backend.api.model.ContactType;
import com.nexos.backend.api.repository.ContactTypeRepository;
import com.nexos.backend.api.vo.ContactTypeVO;
import com.nexos.backend.api.vo.ContactTypeVO;

@Service
public class ContactTypeService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ContactTypeRepository contactTypeRepository;
	
	public List<ContactTypeVO> findAll() throws NexosServiceException{
		try {
			List<ContactTypeVO> contactTypeVOs = new ArrayList<>();
			contactTypeRepository.findAll().forEach((contactType) -> {
				contactTypeVOs.add(modelMapper.map(contactType, ContactTypeVO.class));
			});
			return contactTypeVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_CONTACTTYPE_ERROR, e);
		}
	}
	
	public ContactTypeVO findById(Integer id) throws NexosServiceException {
		try {
			ContactType contactType = contactTypeRepository.findById(id).get();
			return modelMapper.map(contactType, ContactTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_CONTACTTYPE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			contactTypeRepository.delete(contactTypeRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_CONTACTTYPE_ERROR, e);
		}
	}

	public ContactTypeVO create(ContactTypeVO contactTypeVO) throws NexosServiceException {
		try {
			ContactType contactType = contactTypeRepository.save(modelMapper.map(contactTypeVO, ContactType.class));
			return modelMapper.map(contactType, ContactTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_CONTACTTYPE_ERROR, e);
		}
	}
}
