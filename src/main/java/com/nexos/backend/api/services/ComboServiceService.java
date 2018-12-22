package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.ComboService;
import com.nexos.backend.api.repository.ComboServiceRepository;
import com.nexos.backend.api.vo.ComboServiceVO;

@Service
public class ComboServiceService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ComboServiceRepository comboServiceRepository;
	
	public List<ComboServiceVO> findAll() throws NexosServiceException{
		try {
			List<ComboServiceVO> comboServiceVOs = new ArrayList<>();
			comboServiceRepository.findAll().forEach((comboService) -> {
				comboServiceVOs.add(modelMapper.map(comboService, ComboServiceVO.class));
			});
			return comboServiceVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_COMBOSERVICE_ERROR, e);
		}
	}
	
	public ComboServiceVO findById(Integer id) throws NexosServiceException {
		try {
			ComboService comboService = comboServiceRepository.findById(id).get();
			return modelMapper.map(comboService, ComboServiceVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_COMBOSERVICE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			comboServiceRepository.delete(comboServiceRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_COMBOSERVICE_ERROR, e);
		}
	}

	public ComboServiceVO create(ComboServiceVO comboServiceVO) throws NexosServiceException {
		try {
			ComboService comboService = comboServiceRepository.save(modelMapper.map(comboServiceVO, ComboService.class));
			return modelMapper.map(comboService, ComboServiceVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_COMBOSERVICE_ERROR, e);
		}
	}
}
