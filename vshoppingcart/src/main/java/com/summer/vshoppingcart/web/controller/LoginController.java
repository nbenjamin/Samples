package com.summer.vshoppingcart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.service.UserService;
import com.summer.vshoppingcart.service.impl.vscServiceException;

@Controller
@RequestMapping("/")
public class LoginController {


	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "/owners/login";
	}

	@RequestMapping(value = "/owners/login1", method = RequestMethod.POST)
	public String validateLogin(User user, BindingResult result, Model model) {
		try {
			userService.validateUser(user.getUsername(), user.getPassword());
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/owners/index";
	}
}
