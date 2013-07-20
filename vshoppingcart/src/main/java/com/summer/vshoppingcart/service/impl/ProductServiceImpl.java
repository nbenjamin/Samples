package com.summer.vshoppingcart.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.gridfs.GridFSDBFile;
import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.repository.ProductRepository;
import com.summer.vshoppingcart.repository.data.ImageRespositoryImpl;
import com.summer.vshoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ImageRespositoryImpl ImageRespositoryImpl;
	

	public void saveProduct(Product product) throws vscServiceException {
		
		if(ImageRespositoryImpl.storeProductImage(product)!= null) {
			product.setImageGfs(ImageRespositoryImpl.storeProductImage(product));
		}
		productRepository.save(product);

	}


	public List<Product> getAllProducts() throws vscServiceException {
		List<Product> products = productRepository.findAll();
		for(Product product :products) {
			product.getImageGfs();
			GridFSDBFile gridFSDBFile = ImageRespositoryImpl.get(product.getImageGfs());
			try {
				product.setImage1(IOUtils.toByteArray(gridFSDBFile.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

}
