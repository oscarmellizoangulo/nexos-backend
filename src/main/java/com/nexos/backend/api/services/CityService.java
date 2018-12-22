package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.City;
import com.nexos.backend.api.repository.CityRepository;
import com.nexos.backend.api.vo.CityVO;

@Service
public class CityService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private CityRepository cityRepository;
	
	public List<CityVO> findAll() throws NexosServiceException{
		try {
			List<CityVO> citiesVOs = new ArrayList<>();
			cityRepository.findAll().forEach((city) -> {
				citiesVOs.add(modelMapper.map(city, CityVO.class));
			});
			return citiesVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_CITY_ERROR, e);
		}
	}
	
	public CityVO findById(Integer id) throws NexosServiceException {
		try {
			City city = cityRepository.findById(id).get();
			return modelMapper.map(city, CityVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_CITY_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			cityRepository.delete(cityRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_CITY_ERROR, e);
		}
	}

	public CityVO create(CityVO cityVO) throws NexosServiceException {
		try {
			City city = cityRepository.save(modelMapper.map(cityVO, City.class));
			return modelMapper.map(city, CityVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_CITY_ERROR, e);
		}
	}
}
