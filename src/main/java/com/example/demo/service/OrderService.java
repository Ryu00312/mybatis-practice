package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;

	public List<Order> findAll() {
		return orderMapper.findAll();
	}

	public Order findById(Integer id) {
		return orderMapper.findById(id);
	}

	public List<Order> findByProductName(String name) {
		return orderMapper.findByProductName(name);
	}

}
