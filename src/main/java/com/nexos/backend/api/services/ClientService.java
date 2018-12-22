package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Client;
import com.nexos.backend.api.repository.ClientRepository;
import com.nexos.backend.api.vo.ClientVO;

@Service
public class ClientService {	
	private static ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<ClientVO> findAll() throws NexosServiceException{
		try {
			List<ClientVO> clientsVOs = new ArrayList<>();
			clientRepository.findAll().forEach((cli) -> {
				clientsVOs.add(new ClientVO(cli.getPerson().getIdPerson(), cli.getPerson().getDocumentNumber(), 
						cli.getPerson().getFirstName() + " " + cli.getPerson().getLastName()));
				
			});
			return clientsVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_CLIENT_ERROR, e);
		}
	}
	
	public ClientVO findById(Integer id) throws NexosServiceException {
		try {
			Client client = clientRepository.findById(id).get();
			return modelMapper.map(client, ClientVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_CLIENT_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			clientRepository.delete(clientRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_CLIENT_ERROR, e);
		}
	}

	public ClientVO create(ClientVO clientVO) throws NexosServiceException {
		try {
			Client client = clientRepository.save(modelMapper.map(clientVO, Client.class));
			return modelMapper.map(client, ClientVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_CLIENT_ERROR, e);
		}
	}
}
