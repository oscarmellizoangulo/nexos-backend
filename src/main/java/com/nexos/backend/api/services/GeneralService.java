package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.beans.DocumentTypeVO;
import com.nexos.backend.api.beans.ItemVO;
import com.nexos.backend.api.beans.RolVO;
import com.nexos.backend.api.model.DocumentType;
import com.nexos.backend.api.model.Item;
import com.nexos.backend.api.model.Rol;
import com.nexos.backend.api.repository.DocumentTypeRepository;
import com.nexos.backend.api.repository.ItemRepository;
import com.nexos.backend.api.repository.RolRepository;

@Service
public class GeneralService {
	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	public List<DocumentTypeVO> findAllDocumentTypes(){
		Iterable<DocumentType> documentTypes = documentTypeRepository.findAll();
		List<DocumentTypeVO> documentTypeVOs = new ArrayList<DocumentTypeVO>();
		for (DocumentType documentType : documentTypes) {
			DocumentTypeVO documentTypeVO = new DocumentTypeVO(documentType.getIdDocumentType(), documentType.getDocument());
			documentTypeVOs.add(documentTypeVO);
		}
		return documentTypeVOs;
	}
	
	
	public List<RolVO> findAllRols() {
		Iterable<Rol> rols = rolRepository.findAll();
		List<RolVO> rolVOs = new ArrayList<RolVO>(); 
		for (Rol rol : rols) {
			RolVO rolVO = new RolVO(rol.getIdRol(), rol.getRol());
			rolVOs.add(rolVO);
		}
		return rolVOs;
	}
	
	public List<ItemVO> findAllItems() {
		Iterable<Item> items = itemRepository.findAll();
		List<ItemVO> itemVOs = new ArrayList<ItemVO>(); 
		for (Item item : items) {
			ItemVO rolVO = new ItemVO(item.getIdItem(), item.getItem());
			itemVOs.add(rolVO);
		}
		return itemVOs;
	}


	public DocumentTypeVO findDocumentTypeById(Long idDocumentType) {
		DocumentType documentType = documentTypeRepository.findById(idDocumentType).get();
		DocumentTypeVO documentTypeVO = new DocumentTypeVO(documentType.getIdDocumentType(), documentType.getDocument());
		return documentTypeVO;
	}


	public RolVO findRolById(Long idRol) {
		Rol rol = rolRepository.findById(idRol).get();
		RolVO rolVO = new RolVO(rol.getIdRol(), rol.getRol());
		return rolVO;
	}


	public ItemVO findItemById(Long idItem) {
		Item item = itemRepository.findById(idItem).get();
		ItemVO itemVO = new ItemVO(item.getIdItem(), item.getItem());
		return itemVO;
	}
}
