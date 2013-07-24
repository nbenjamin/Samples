package com.summer.vshoppingcart.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.domain.Type;

public interface ProductRepository extends Repository<Product, BigInteger> {
	
	Page<Product> findAll(Pageable pageable) throws DataAccessException;

	List<Product> findByType(Type type, Pageable pageable) throws DataAccessException;
	
	void save(Product product) throws DataAccessException;
	
	List<Product> findByEffectiveDate() throws DataAccessException;
	
	Product findOne(BigInteger id) throws DataAccessException;

}
