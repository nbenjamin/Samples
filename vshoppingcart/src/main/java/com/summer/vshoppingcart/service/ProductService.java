package com.summer.vshoppingcart.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.domain.Type;
import com.summer.vshoppingcart.service.impl.vscServiceException;

public interface ProductService {

	void saveProduct(Product product) throws vscServiceException;
	
	List<Product> getAllProducts() throws vscServiceException;
	
	Map<Type, List<Product>> getLatestProducts() throws vscServiceException;
	
	List<Product> getProductsByType(Type type) throws vscServiceException;
	
	Product getProductById(BigInteger Id) throws vscServiceException;
}
