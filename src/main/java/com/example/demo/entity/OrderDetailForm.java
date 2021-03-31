package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderDetailForm {
	private Integer id;
	private String name;
	private String storeName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;
	private Integer orderNum;
	private String master;
}
