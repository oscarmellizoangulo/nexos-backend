package com.nexos.backend.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.backend.api.exception.Message;
import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.services.DepartmentService;
import com.nexos.backend.api.vo.DepartmentVO;

@RestController
@RequestMapping("/nexos-api/department")
public class DepartmentResource {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/findAll")
	public ResponseEntity findAll() {
		try {
			return new ResponseEntity<List<DepartmentVO>>(departmentService.findAll(), HttpStatus.OK);
		}catch(NexosServiceException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(e.getCode()));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(MessageCode.ERROR_SISTEMA));
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<DepartmentVO>(departmentService.findById(id), HttpStatus.OK);
		}catch(NexosServiceException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(e.getCode()));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(MessageCode.ERROR_SISTEMA));
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable Integer id) {
		try {
			departmentService.deleteById(id);
			return new ResponseEntity(HttpStatus.OK);
		}catch(NexosServiceException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(e.getCode()));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(MessageCode.ERROR_SISTEMA));
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity create(@RequestBody DepartmentVO departmentVO) {
		try {
			departmentVO = departmentService.create(departmentVO);
			return new ResponseEntity<DepartmentVO>(departmentVO, HttpStatus.OK);
		}catch(NexosServiceException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(e.getCode()));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Message.getMessage(MessageCode.ERROR_SISTEMA));
		}
	}
}
