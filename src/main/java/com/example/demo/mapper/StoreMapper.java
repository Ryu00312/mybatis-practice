package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Store;

@Mapper
@Repository
public interface StoreMapper {

	@Select("select * from store")
	List<Store> findAll();
	
	@Select("select * from store where store_name = #{storeName} ")
	Store findByStoreName(String storeName);
	
}
