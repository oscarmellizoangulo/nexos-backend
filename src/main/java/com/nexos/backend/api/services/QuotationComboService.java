package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.QuotationCombo;
import com.nexos.backend.api.model.QuotationCombo;
import com.nexos.backend.api.model.QuotationComboPK;
import com.nexos.backend.api.repository.QuotationComboRepository;
import com.nexos.backend.api.vo.QuotationComboVO;
import com.nexos.backend.api.vo.QuotationComboVO;

@Service
public class QuotationComboService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private QuotationComboRepository quotationComboRepository;
	
	public List<QuotationComboVO> findAll() throws NexosServiceException{
		try {
			List<QuotationComboVO> quotationComboVOs = new ArrayList<>();
			quotationComboRepository.findAll().forEach((quotationCombo) -> {
				quotationComboVOs.add(modelMapper.map(quotationCombo, QuotationComboVO.class));
			});
			return quotationComboVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_QUOTATIONCOMBO_ERROR, e);
		}
	}
	
	public QuotationComboVO findById(QuotationComboPK id) throws NexosServiceException {
		try {
			QuotationCombo quotationCombo = quotationComboRepository.findById(id).get();
			return modelMapper.map(quotationCombo, QuotationComboVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_QUOTATIONCOMBO_ERROR, e);
		}
	}
	
	public void deleteById(QuotationComboPK id) throws NexosServiceException {
		try {
			quotationComboRepository.delete(quotationComboRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_QUOTATIONCOMBO_ERROR, e);
		}
	}

	public QuotationComboVO create(QuotationComboVO quotationComboVO) throws NexosServiceException {
		try {
			QuotationCombo quotationCombo = quotationComboRepository.save(modelMapper.map(quotationComboVO, QuotationCombo.class));
			return modelMapper.map(quotationCombo, QuotationComboVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_QUOTATIONCOMBO_ERROR, e);
		}
	}
}
