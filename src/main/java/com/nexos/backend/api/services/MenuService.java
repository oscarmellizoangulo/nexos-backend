package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Menu;
import com.nexos.backend.api.repository.MenuRepository;
import com.nexos.backend.api.vo.MenuVO;

@Service
public class MenuService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private MenuRepository menuRepository;
	
	public List<MenuVO> findAll() throws NexosServiceException{
		try {
			List<MenuVO> menuVOs = new ArrayList<>();
			menuRepository.findAll().forEach((menu) -> {
				menuVOs.add(modelMapper.map(menu, MenuVO.class));
			});
			return menuVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_MENU_ERROR, e);
		}
	}
	
	public MenuVO findById(Integer id) throws NexosServiceException {
		try {
			Menu menu = menuRepository.findById(id).get();
			return modelMapper.map(menu, MenuVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_MENU_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			menuRepository.delete(menuRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_MENU_ERROR, e);
		}
	}

	public MenuVO create(MenuVO menuVO) throws NexosServiceException {
		try {
			Menu menu = menuRepository.save(modelMapper.map(menuVO, Menu.class));
			return modelMapper.map(menu, MenuVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_MENU_ERROR, e);
		}
	}
}
