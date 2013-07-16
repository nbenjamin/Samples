package com.summer.vshoppingcart.repository.data;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import com.summer.vshoppingcart.domain.User;

public interface UserJPARepository extends Repository<User, Integer> {

	List<User> findByUsername(String username);
	
	List<User> findByUsernameAndPassword(String username, String password);
	
	void save(User user) throws DataAccessException;

}
