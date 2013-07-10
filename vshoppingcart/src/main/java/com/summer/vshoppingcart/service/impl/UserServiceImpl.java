package com.summer.vshoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.repository.data.UserJPARepository;
import com.summer.vshoppingcart.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserJPARepository userRepository;
	
	public User validateUser(String userName, String password)
			throws vscServiceException {
		/*List<User> users = userRepository.findByUserName(userName);
		if(users!=null && users.size()>0) {
			return users.get(0);
		} else {
			return null;
		}*/
		return null;
	}

}
