package com.summer.vshoppingcart.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import com.summer.vshoppingcart.domain.Product;

public interface ProductRepository extends Repository<Product, Integer> {
	
	List<Product> findAll() throws DataAccessException;

	void save(Product product) throws DataAccessException;

}
