package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.ServiceType;
import com.nexos.backend.api.repository.ServiceTypeRepository;
import com.nexos.backend.api.vo.ServiceTypeVO;

@Service
public class ServiceTypeService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	
	public List<ServiceTypeVO> findAll() throws NexosServiceException{
		try {
			List<ServiceTypeVO> serviceTypeVOs = new ArrayList<>();
			serviceTypeRepository.findAll().forEach((serviceType) -> {
				serviceTypeVOs.add(modelMapper.map(serviceType, ServiceTypeVO.class));
			});
			return serviceTypeVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_SERVICETYPE_ERROR, e);
		}
	}
	
	public ServiceTypeVO findById(Integer id) throws NexosServiceException {
		try {
			ServiceType serviceType = serviceTypeRepository.findById(id).get();
			return modelMapper.map(serviceType, ServiceTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_SERVICETYPE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			serviceTypeRepository.delete(serviceTypeRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_SERVICETYPE_ERROR, e);
		}
	}

	public ServiceTypeVO create(ServiceTypeVO serviceTypeVO) throws NexosServiceException {
		try {
			ServiceType serviceType = serviceTypeRepository.save(modelMapper.map(serviceTypeVO, ServiceType.class));
			return modelMapper.map(serviceType, ServiceTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_SERVICETYPE_ERROR, e);
		}
	}
}
