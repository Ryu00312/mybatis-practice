package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Store;
import com.example.demo.mapper.StoreMapper;

@Service
@Transactional
public class StoreService {

	@Autowired
	private StoreMapper storeMapper;

	public List<Store> findAll() {
		return storeMapper.findAll();
	}

	public Store findByStoreName(String storeName) {
		return storeMapper.findByStoreName(storeName);
	}

}
