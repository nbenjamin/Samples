package com.summer.vshoppingcart.service;

import org.springframework.stereotype.Service;

import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.service.impl.vscServiceException;

@Service
public interface UserService {

	User validateUser(String userName, String password) throws vscServiceException;
	
}
