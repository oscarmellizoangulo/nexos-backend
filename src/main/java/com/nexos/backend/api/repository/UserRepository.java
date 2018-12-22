package com.nexos.backend.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.backend.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByUserNameAndPassword(String userName, String password);
	public User findByUserName(String userName);
}
