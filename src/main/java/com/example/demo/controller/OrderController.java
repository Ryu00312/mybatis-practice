package com.example.demo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetailForm;
import com.example.demo.entity.ParentForm;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = { "/{name}" }, method = { GET, POST })
	public String getOrderList(@ModelAttribute ParentForm parentForm,
			@RequestBody @PathVariable(name = "name", required = false) String name,
			Model model) {
		if (CollectionUtils.isEmpty(parentForm.getOrderDetailEditForms())
				|| CollectionUtils.isEmpty(parentForm.getOrderDetailMasterForms())) {

			List<Order> orders = orderService.findByProductName(name);
			List<OrderDetailForm> orderDetailForms = new ArrayList<OrderDetailForm>();
			for (Order order : orders) {
				OrderDetailForm orderDetailForm = new OrderDetailForm();
				BeanUtils.copyProperties(order, orderDetailForm);
				orderDetailForms.add(orderDetailForm);
			}
			parentForm.setOrderDetailEditForms(orderDetailForms);
			parentForm.setOrderDetailMasterForms(orderDetailForms);
		}
		model.addAttribute("parentForm", parentForm);
		return "orders/list";
	}

	@PostMapping(value = "/detail")
	public String getOrderDetail(@ModelAttribute ParentForm parentForm) {
		return "orders/detail";
	}
}
