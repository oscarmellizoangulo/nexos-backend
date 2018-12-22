package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Quotation;
import com.nexos.backend.api.repository.QuotationRepository;
import com.nexos.backend.api.vo.QuotationVO;

@Service
public class QuotationService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private QuotationRepository quotationRepository;
	
	public List<QuotationVO> findAll() throws NexosServiceException{
		try {
			List<QuotationVO> quotationVOs = new ArrayList<>();
			quotationRepository.findAll().forEach((quotation) -> {
				quotationVOs.add(modelMapper.map(quotation, QuotationVO.class));
			});
			return quotationVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_QUOTATION_ERROR, e);
		}
	}
	
	public QuotationVO findById(Integer id) throws NexosServiceException {
		try {
			Quotation quotation = quotationRepository.findById(id).get();
			return modelMapper.map(quotation, QuotationVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_QUOTATION_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			quotationRepository.delete(quotationRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_QUOTATION_ERROR, e);
		}
	}

	public QuotationVO create(QuotationVO quotationVO) throws NexosServiceException {
		try {
			Quotation quotation = quotationRepository.save(modelMapper.map(quotationVO, Quotation.class));
			return modelMapper.map(quotation, QuotationVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_QUOTATION_ERROR, e);
		}
		
		
	}
}
