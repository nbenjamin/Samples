package com.summer.vshoppingcart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summer.vshoppingcart.domain.User;

@Controller
@RequestMapping("/")
public class VShoppingController {

	@RequestMapping(value = "/owners/index", method = RequestMethod.POST)
	public String validateLogin(User user, BindingResult result, Model model) {
		System.out.println(user);
		return "/owners/index";
	}
}
