package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;

@Mapper
@Repository
public interface OrderMapper {

	@Select("select * from order order by id")
	List<Order> findAll();
	
	@Select("select * from order where id = #{id}")
	Order findById(Integer id);
	
	@Select("select * from public.order where name = #{name} order by id")
	List<Order> findByProductName(String name);
	
	

}
