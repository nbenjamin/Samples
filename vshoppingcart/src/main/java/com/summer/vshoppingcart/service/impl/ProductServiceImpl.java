package com.summer.vshoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.repository.ProductRepository;
import com.summer.vshoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public void saveProduct(Product product) throws vscServiceException {
		productRepository.save(product);

	}

}
