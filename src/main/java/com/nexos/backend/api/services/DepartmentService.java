package com.nexos.backend.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.backend.api.exception.MessageCode;
import com.nexos.backend.api.exception.NexosServiceException;
import com.nexos.backend.api.model.Department;
import com.nexos.backend.api.model.Department;
import com.nexos.backend.api.repository.DepartmentRepository;
import com.nexos.backend.api.vo.DepartmentVO;
import com.nexos.backend.api.vo.DepartmentVO;

@Service
public class DepartmentService {
	private static ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<DepartmentVO> findAll() throws NexosServiceException{
		try {
			List<DepartmentVO> departmentVOs = new ArrayList<>();
			departmentRepository.findAll().forEach((department) -> {
				departmentVOs.add(modelMapper.map(department, DepartmentVO.class));
			});
			return departmentVOs;
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_ALL_DEPARTMENT_ERROR, e);
		}
	}
	
	public DepartmentVO findById(Integer id) throws NexosServiceException {
		try {
			Department department = departmentRepository.findById(id).get();
			return modelMapper.map(department, DepartmentVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.FIND_DEPARTMENT_ERROR, e);
		}
	}
	
	public void deleteById(Integer id) throws NexosServiceException {
		try {
			departmentRepository.delete(departmentRepository.findById(id).get());
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.DELETE_DEPARTMENT_ERROR, e);
		}
	}

	public DepartmentVO create(DepartmentVO departmentVO) throws NexosServiceException {
		try {
			Department department = departmentRepository.save(modelMapper.map(departmentVO, Department.class));
			return modelMapper.map(department, DepartmentVO.class);
		}catch(Exception e) {
			throw new NexosServiceException(MessageCode.CREATE_DEPARTMENT_ERROR, e);
		}
	}
}
