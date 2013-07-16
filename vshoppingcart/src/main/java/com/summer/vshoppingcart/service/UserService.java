package com.summer.vshoppingcart.service;

import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.service.impl.vscServiceException;


public interface UserService {

	User validateUser(String userName, String password) throws vscServiceException;
	
	void saveUser(User user) throws vscServiceException;
	
}
