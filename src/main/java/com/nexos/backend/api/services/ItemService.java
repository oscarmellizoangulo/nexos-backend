package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Item;
import com.nexos.backend.api.repository.ItemRepository;
import com.nexos.backend.api.vo.ItemVO;

@Service
public class ItemService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private ItemRepository itemRepository;
	
	public List<ItemVO> findAll() throws NexosServiceException{
		try {
			List<ItemVO> itemVOs = new ArrayList<>();
			itemRepository.findAll().forEach((item) -> {
				itemVOs.add(modelMapper.map(item, ItemVO.class));
			});
			return itemVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_ITEM_ERROR, e);
		}
	}
	
	public ItemVO findById(Integer id) throws NexosServiceException {
		try {
			Item item = itemRepository.findById(id).get();
			return modelMapper.map(item, ItemVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ITEM_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			itemRepository.delete(itemRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_ITEM_ERROR, e);
		}
	}

	public ItemVO create(ItemVO itemVO) throws NexosServiceException {
		try {
			Item item = itemRepository.save(modelMapper.map(itemVO, Item.class));
			return modelMapper.map(item, ItemVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_ITEM_ERROR, e);
		}
	}
}
