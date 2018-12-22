package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Combo;
import com.nexos.backend.api.repository.ComboRepository;
import com.nexos.backend.api.vo.ComboVO;

@Service
public class ComboService {
	private static ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ComboRepository comboRepository;
	
	public List<ComboVO> findAll() throws NexosServiceException{
		try {
			List<ComboVO> combosVOs = new ArrayList<>();
			comboRepository.findAll().forEach((combo) -> {
				combosVOs.add(modelMapper.map(combo, ComboVO.class));
				
			});
			return combosVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_COMBO_ERROR, e);
		}
	}
	
	public ComboVO findById(Integer id) throws NexosServiceException {
		try {
			Combo combo = comboRepository.findById(id).get();
			return modelMapper.map(combo, ComboVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_COMBO_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			comboRepository.delete(comboRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_COMBO_ERROR, e);
		}
	}

	public ComboVO create(ComboVO comboVO) throws NexosServiceException {
		try {
			Combo combo = comboRepository.save(modelMapper.map(comboVO, Combo.class));
			return modelMapper.map(combo, ComboVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_COMBO_ERROR, e);
		}
	}
}
