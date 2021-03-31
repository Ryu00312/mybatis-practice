package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
@Mapper
public interface UserMapper {
	List<User> findAll();
	
	User findById(int id);
	
	int insert(User user);
	
	int update(User user);
	
	int delete(User user);
}