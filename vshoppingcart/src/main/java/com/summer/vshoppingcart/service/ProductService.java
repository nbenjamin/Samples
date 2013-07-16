package com.summer.vshoppingcart.service;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.service.impl.vscServiceException;

public interface ProductService {

	void saveProduct(Product product) throws vscServiceException;
}
