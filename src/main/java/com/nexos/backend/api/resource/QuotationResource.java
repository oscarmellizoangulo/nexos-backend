package com.nexos.backend.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.backend.api.beans.QuotationVO;
import com.nexos.backend.api.exception.UserNotFoundException;
import com.nexos.backend.api.services.QuotationService;

@RestController
@RequestMapping("/nexos-api/quotation")
public class QuotationResource {
	@Autowired
	private QuotationService quotationResource;
	@PostMapping("/recovery")
	public ResponseEntity create(@RequestBody QuotationVO quotationVO) {
		try {
			return ResponseEntity
		            .status(HttpStatus.OK)                 
		            .body(quotationResource.create());
		}catch(UserNotFoundException e) {
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body(e.getMessage());
		}
	}
}
