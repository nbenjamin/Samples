package com.summer.vshoppingcart.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.domain.Type;
import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.service.ProductService;
import com.summer.vshoppingcart.service.impl.vscServiceException;

@Controller
@RequestMapping("/")
public class VShoppingController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String validateLogin(User user, BindingResult result, Model model) {
		System.out.println(user);
		return "/owners/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String welcome(User user, BindingResult result, Model model) {
		return "index";
	}

	@ModelAttribute("latestProducts")
	public Map<Type, List<Product>> getLatestProductsByType() {
		Map<Type, List<Product>> map = new HashMap<Type, List<Product>>();
		try {
			map = productService.getLatestProducts();
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
