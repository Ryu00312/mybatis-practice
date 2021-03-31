package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetailForm;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping(value = "/{name}")
	public String getOrderList(@RequestBody @PathVariable("name") String name, Model model) {
		List<Order> orders = orderService.findByProductName(name);
		String base64Strings = "";
		// hidden属性の仕様でリストがString配列になる、よってリスト→文字列にする必要がある。
		// オブジェクトごとにバイナリ化、base64エンコードし、カンマ区切りで文字列連結
		for (Order order : orders) {
			byte[] orderByte = Order.getByteObject(order);
			String encoded = Base64.getEncoder().encodeToString(orderByte);
			base64Strings = base64Strings == "" ? encoded : String.join(",", base64Strings, encoded);
		}
		model.addAttribute("master", base64Strings);
		model.addAttribute("edit", orders);
		return "orders/list";
	}

	@PostMapping(value = "")
	public String getOrderList(@ModelAttribute OrderDetailForm orderDetailForm, Model model) {
		model.addAttribute("master", orderDetailForm.getMaster());

		// カンマ区切りのbase64の文字列をスプリット、デコード、オブジェクトに変換、リスト化
		List<Order> orders = new ArrayList<Order>();
		String[] lineStrings = orderDetailForm.getMaster().split(",");
		for (String string : lineStrings) {
			byte[] decoded = Base64.getDecoder().decode(string);
			Order order = Order.createOrderObject(decoded);
			if (orderDetailForm.getId().equals(order.getId())) {
				// レコードを上書き
				BeanUtils.copyProperties(orderDetailForm, order);
			}
			orders.add(order);
		}
		model.addAttribute("edit", orders);
		return "orders/list";

	}

	@PostMapping(value = "/detail")
	public String getOrderDetail(@ModelAttribute OrderDetailForm orderDetailForm, Model model) {
		return "orders/detail";
	}
}
