package com.summer.vshoppingcart.web.controller;

import java.math.BigInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summer.vshoppingcart.domain.Product;

@Controller
@RequestMapping("/")
public class CartController {

	@RequestMapping(value = "/order/add/{id}/{quantity}")
	public String addToCart(@PathVariable("id") BigInteger id,@PathVariable("quantity") BigInteger quantity, Product product,
			Model model) {
		System.out.println(id);
		System.out.println(quantity);
		return "/order/cart";
	}

}
