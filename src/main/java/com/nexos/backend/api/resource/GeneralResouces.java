package com.nexos.backend.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.backend.api.beans.DocumentTypeVO;
import com.nexos.backend.api.beans.ItemVO;
import com.nexos.backend.api.beans.RolVO;
import com.nexos.backend.api.exception.UserNotFoundException;
import com.nexos.backend.api.services.GeneralService;

@RestController
@RequestMapping("/nexos-api/general")
public class GeneralResouces {
	@Autowired
	private GeneralService generalService; 
		
	@PostMapping("/findAllDocumentTypes")
	public ResponseEntity findAllDocumentTypes() {
		try {
			return new ResponseEntity<List<DocumentTypeVO>>(generalService.findAllDocumentTypes(), HttpStatus.OK);
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	
	@GetMapping("/findDocumentTypeById/{idDocumentType}")
	public ResponseEntity findDocumentTypeById(@PathVariable Long idDocumentType) {
		try {
			return new ResponseEntity<DocumentTypeVO>(generalService.findDocumentTypeById(idDocumentType), HttpStatus.OK);
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	
	@PostMapping("/findAllRols")
	public ResponseEntity findAllRols() {
		try {
			return new ResponseEntity<List<RolVO>>(generalService.findAllRols(), HttpStatus.OK);
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	
	@GetMapping("/findRolById/{idRol}")
	public ResponseEntity findRolById(@PathVariable Long idRol) {
		try {
			return new ResponseEntity<RolVO>(generalService.findRolById(idRol), HttpStatus.OK);
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	
	@PostMapping("/findAllItems")
	public ResponseEntity findAllItems() {
		try {
			return new ResponseEntity<List<ItemVO>>(generalService.findAllItems(), HttpStatus.OK);
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	
	@GetMapping("/findItemById/{idItem}")
	public ResponseEntity findItemById(@PathVariable Long idItem) {
		try {
			return new ResponseEntity<ItemVO>(generalService.findItemById(idItem), HttpStatus.OK);
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
	
}
