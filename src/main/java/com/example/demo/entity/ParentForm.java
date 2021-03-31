package com.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class ParentForm {
	private List<OrderDetailForm> orderDetailEditForms;
	private List<OrderDetailForm> orderDetailMasterForms;
}
