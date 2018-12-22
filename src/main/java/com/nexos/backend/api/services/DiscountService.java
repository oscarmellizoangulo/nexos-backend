package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Discount;
import com.nexos.backend.api.model.Discount;
import com.nexos.backend.api.repository.DiscountRepository;
import com.nexos.backend.api.vo.DiscountVO;
import com.nexos.backend.api.vo.DiscountVO;

@Service
public class DiscountService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private DiscountRepository discountRepository;
	
	public List<DiscountVO> findAll() throws NexosServiceException{
		try {
			List<DiscountVO> discountVOs = new ArrayList<>();
			discountRepository.findAll().forEach((discount) -> {
				discountVOs.add(modelMapper.map(discount, DiscountVO.class));
			});
			return discountVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_DISCOUNT_ERROR, e);
		}
	}
	
	public DiscountVO findById(Integer id) throws NexosServiceException {
		try {
			Discount discount = discountRepository.findById(id).get();
			return modelMapper.map(discount, DiscountVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_DISCOUNT_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			discountRepository.delete(discountRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_DISCOUNT_ERROR, e);
		}
	}

	public DiscountVO create(DiscountVO discountVO) throws NexosServiceException {
		try {
			Discount discount = discountRepository.save(modelMapper.map(discountVO, Discount.class));
			return modelMapper.map(discount, DiscountVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_DISCOUNT_ERROR, e);
		}
	}
}
