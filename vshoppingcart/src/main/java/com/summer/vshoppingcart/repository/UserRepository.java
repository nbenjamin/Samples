package com.summer.vshoppingcart.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.summer.vshoppingcart.domain.User;

public interface UserRepository {

	List<User> findByUser() throws DataAccessException;

	User findById(int id) throws DataAccessException;

	void save(User user) throws DataAccessException;

}
