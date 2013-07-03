package com.summer.vshoppingcart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summer.vshoppingcart.domain.User;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model) {
		User user = new User();
		model.addAttribute(user);
		return "/owners/login";
	}

	@RequestMapping(value = "/owners/login1", method = RequestMethod.GET)
	public String validateLogin(User user, BindingResult result, Model model) {
		System.out.println(user);
		return "index";
	}
}
