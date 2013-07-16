package com.summer.vshoppingcart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.service.ProductService;
import com.summer.vshoppingcart.service.impl.vscServiceException;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/owners/product", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String viewProductDetails(User user, BindingResult result, Model model) {
	
		return "/owners/product";
	}
	
	
	@RequestMapping(value = "/products/addnew", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String saveProducts(Product product, BindingResult result, Model model) {
		if(!StringUtils.isEmpty(product.getName())) {
			try {
				productService.saveProduct(product);
			} catch (vscServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "/products/AddProducts";
	}

}
