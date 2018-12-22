package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Country;
import com.nexos.backend.api.repository.CountryRepository;
import com.nexos.backend.api.vo.CountryVO;

@Service
public class CountryService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private CountryRepository countryRepository;
	
	public List<CountryVO> findAll() throws NexosServiceException{
		try {
			List<CountryVO> countryVOs = new ArrayList<>();
			countryRepository.findAll().forEach((country) -> {
				countryVOs.add(modelMapper.map(country, CountryVO.class));
			});
			return countryVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_COUNTRY_ERROR, e);
		}
	}
	
	public CountryVO findById(Integer id) throws NexosServiceException {
		try {
			Country country = countryRepository.findById(id).get();
			return modelMapper.map(country, CountryVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_COUNTRY_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			countryRepository.delete(countryRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_COUNTRY_ERROR, e);
		}
	}

	public CountryVO create(CountryVO countryVO) throws NexosServiceException {
		try {
			Country country = countryRepository.save(modelMapper.map(countryVO, Country.class));
			return modelMapper.map(country, CountryVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_COUNTRY_ERROR, e);
		}
	}
}
