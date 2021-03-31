package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	public List<Product> findAll() {
		return productMapper.findAll();
	}

	public Product findByProductName(String name) {
		return productMapper.findByProductName(name);
	}
}
