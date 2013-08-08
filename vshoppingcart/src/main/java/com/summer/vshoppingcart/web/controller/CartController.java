package com.summer.vshoppingcart.web.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summer.vshoppingcart.domain.Order;
import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.service.CartService;
import com.summer.vshoppingcart.service.ProductService;
import com.summer.vshoppingcart.service.impl.vscServiceException;

@Controller
@RequestMapping("/")
@Scope("session")
public class CartController {
	
	@Autowired
	private CartService cartService; 

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/order/add/{id}/{quantity}")
	public String addToCart(@PathVariable("id") BigInteger id,@PathVariable("quantity") BigInteger quantity, Product product,
			Model model) {
		System.out.println(id);
		System.out.println(quantity);
		Product item = null;
		try {
			item = productService.getProductById(id);
			cartService.addItem(item, quantity);
			model.addAttribute("cart",cartService.getItems());
			//model.addAttribute("cart",cartService.getItems());
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/order/cart";
	}
	
	
	@RequestMapping(value = "/order/checkout")
	public String checkout(Model model){
		Order order = new Order();
		model.addAttribute("order",order);
		return "/order/checkout";
	}
	
	
	
	

}
