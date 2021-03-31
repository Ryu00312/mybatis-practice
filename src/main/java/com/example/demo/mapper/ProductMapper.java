package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Mapper
@Repository
public interface ProductMapper {

	@Select("select * from product")
	List<Product> findAll();
	
	@Select("select * from product where name = #{name}")
	Product findByProductName(@Param("name")String name);	

}
