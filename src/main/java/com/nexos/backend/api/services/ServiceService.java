package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.repository.ServiceRepository;
import com.nexos.backend.api.vo.ServiceVO;

@Service
public class ServiceService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ServiceRepository serviceRepository;
	
	public List<ServiceVO> findAll() throws NexosServiceException{
		try {
			List<ServiceVO> serviceVOs = new ArrayList<>();
			serviceRepository.findAll().forEach((service) -> {
				serviceVOs.add(modelMapper.map(service, ServiceVO.class));
			});
			return serviceVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_SERVICE_ERROR, e);
		}
	}
	
	public ServiceVO findById(Integer id) throws NexosServiceException {
		try {
			com.nexos.backend.api.model.Service service = serviceRepository.findById(id).get();
			return modelMapper.map(service, ServiceVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_SERVICE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			serviceRepository.delete(serviceRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_SERVICE_ERROR, e);
		}
	}

	public ServiceVO create(ServiceVO serviceVO) throws NexosServiceException {
		try {
			com.nexos.backend.api.model.Service service = serviceRepository.save(modelMapper.map(serviceVO, com.nexos.backend.api.model.Service.class));
			return modelMapper.map(service, ServiceVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_SERVICE_ERROR, e);
		}
	}
}
