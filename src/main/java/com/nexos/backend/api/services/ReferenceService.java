package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Reference;
import com.nexos.backend.api.repository.ReferenceRepository;
import com.nexos.backend.api.vo.ReferenceVO;

@Service
public class ReferenceService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ReferenceRepository referenceRepository;
	
	public List<ReferenceVO> findAll() throws NexosServiceException{
		try {
			List<ReferenceVO> referenceVOs = new ArrayList<>();
			referenceRepository.findAll().forEach((reference) -> {
				referenceVOs.add(modelMapper.map(reference, ReferenceVO.class));
			});
			return referenceVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_REFERENCE_ERROR, e);
		}
	}
	
	public ReferenceVO findById(Integer id) throws NexosServiceException {
		try {
			Reference reference = referenceRepository.findById(id).get();
			return modelMapper.map(reference, ReferenceVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_REFERENCE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			referenceRepository.delete(referenceRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_REFERENCE_ERROR, e);
		}
	}
}
