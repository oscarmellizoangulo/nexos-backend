package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Address;
import com.nexos.backend.api.repository.AddressRepository;
import com.nexos.backend.api.vo.AddressVO;

@Service
public class AddressService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private AddressRepository addressRepository;
	
	public List<AddressVO> findAll() throws NexosServiceException{
		try {
			List<AddressVO> addressVOs = new ArrayList<>();
			addressRepository.findAll().forEach((address) -> {
				addressVOs.add(modelMapper.map(address, AddressVO.class));
			});
			return addressVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_ADDRESS_ERROR, e);
		}
	}
	
	public AddressVO findById(Integer id) throws NexosServiceException {
		try {
			Address address = addressRepository.findById(id).get();
			return modelMapper.map(address, AddressVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ADDRESS_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			addressRepository.delete(addressRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_ADDRESS_ERROR, e);
		}
	}

	public AddressVO create(AddressVO addressVO) throws NexosServiceException {
		try {
			Address address = addressRepository.save(modelMapper.map(addressVO, Address.class));
			return modelMapper.map(address, AddressVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_ADDRESS_ERROR, e);
		}
	}
}
