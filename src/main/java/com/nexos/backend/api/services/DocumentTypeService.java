package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.DocumentType;
import com.nexos.backend.api.repository.DocumentTypeRepository;
import com.nexos.backend.api.vo.DocumentTypeVO;

@Service
public class DocumentTypeService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	public List<DocumentTypeVO> findAll() throws NexosServiceException{
		try {
			List<DocumentTypeVO> documentTypeVOs = new ArrayList<>();
			documentTypeRepository.findAll().forEach((documentType) -> {
				documentTypeVOs.add(modelMapper.map(documentType, DocumentTypeVO.class));
			});
			return documentTypeVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_DOCUMENTTYPE_ERROR, e);
		}
	}
	
	public DocumentTypeVO findById(Integer id) throws NexosServiceException {
		try {
			DocumentType documentType = documentTypeRepository.findById(id).get();
			return modelMapper.map(documentType, DocumentTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_DOCUMENTTYPE_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			documentTypeRepository.delete(documentTypeRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_DOCUMENTTYPE_ERROR, e);
		}
	}

	public DocumentTypeVO create(DocumentTypeVO documentTypeVO) throws NexosServiceException {
		try {
			DocumentType documentType = documentTypeRepository.save(modelMapper.map(documentTypeVO, DocumentType.class));
			return modelMapper.map(documentType, DocumentTypeVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_DOCUMENTTYPE_ERROR, e);
		}
	}
}
