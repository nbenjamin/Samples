package com.summer.vshoppingcart.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.summer.vshoppingcart.domain.User;

@Component
public interface UserRepository {

	List<User> findByUser() throws DataAccessException;

	User findById(int id) throws DataAccessException;

	void save(User user) throws DataAccessException;

}
