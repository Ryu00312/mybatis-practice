package com.example.demo.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Order implements Serializable{
	private Integer id;
	private String name;
	private String storeName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;
	private Integer orderNum;
	
	
	
	public static byte[] getByteObject(Order order) {
		byte[] retObject = null;
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(order);
			objectOutputStream.close();
			byteArrayOutputStream.close();
			retObject = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			// TODO: handle exception
		}
		return retObject;
	}
	
	public static Order createOrderObject(byte[] objByte) {
		Order order =null;
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(objByte);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			order = (Order)objectInputStream.readObject();
			byteArrayInputStream.close();
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
		}
		return order;		
	}
}