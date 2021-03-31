package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public List<User> findAll() {
		return userMapper.findAll();
	}
}
