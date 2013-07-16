package com.summer.vshoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.vshoppingcart.domain.User;
import com.summer.vshoppingcart.repository.data.UserJPARepository;
import com.summer.vshoppingcart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserJPARepository userJPARepository;
	
	public User validateUser(String userName, String password)
			throws vscServiceException {
		List<User> users = userJPARepository.findByUsername(userName);
		if(users!=null && users.size()>0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public void saveUser(User user) throws vscServiceException {
		userJPARepository.save(user);
	}

}
