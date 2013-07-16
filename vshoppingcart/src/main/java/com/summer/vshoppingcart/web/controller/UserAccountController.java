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
public class UserAccountController {
	
	@Autowired
	UserService userService; 

	@RequestMapping(value = "/owners/createAccount", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String createAccount(User user, BindingResult result, Model model) {
		System.out.println(user);
		if (user.getUsername() != null) {
			try {
				userService.saveUser(user);
			} catch (vscServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "/owners/index";
		}
		else {
			return "/owners/createAccount";
		}
	}
}
