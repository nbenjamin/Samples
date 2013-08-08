package com.summer.vshoppingcart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summer.vshoppingcart.domain.Order;

@Controller
public class OrderController {

	@RequestMapping(value="/order/placeorder")
	public String placeOrder(final Order order, final BindingResult bindingResult) {
		System.out.println(order);
		return "/order/orderDetails";
	}

}
