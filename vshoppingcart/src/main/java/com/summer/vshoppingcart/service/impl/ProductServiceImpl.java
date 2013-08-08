package com.summer.vshoppingcart.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.domain.Type;
import com.summer.vshoppingcart.repository.FileStorageRepository;
import com.summer.vshoppingcart.repository.ProductRepository;
import com.summer.vshoppingcart.repository.data.ImageRespositoryImpl;
import com.summer.vshoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	FileStorageRepository fileStorageRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ImageRespositoryImpl ImageRespositoryImpl;
	

	public void saveProduct(Product product) throws vscServiceException {
		// we are not saving in to mongo db for now
		if(ImageRespositoryImpl.storeProductImage(product)!= null) {
			product.setImageGfs(ImageRespositoryImpl.storeProductImage(product));
		}
		
		// No more file saving
		/*String path = fileStorageRepository.storeProductImage(product);
		product.setImagepath(path);*/
		productRepository.save(product);

	}


	public List<Product> getAllProducts() throws vscServiceException {
		
		final PageRequest homePageRequest = new PageRequest(
				  0, 4, Direction.DESC, "price"
				);
		Page<Product> productsPage = productRepository.findAll(homePageRequest);
		List<Product> products = productsPage.getContent();
		for(Product product :products) {
			product.getImageGfs();
			//GridFSDBFile gridFSDBFile = ImageRespositoryImpl.get(product.getImageGfs());
			try {
				product.setImageByte(ImageRespositoryImpl.findOne(product.getImageGfs()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}


	public Map<Type, List<Product>> getLatestProducts()
			throws vscServiceException {
		final PageRequest homePageRequest = new PageRequest(
				  0,4, Direction.DESC, "price"
				);
		List<Product> productsByTypeChuridar = new ArrayList<Product>();
		for(Product product :productRepository.findByType(Type.CHURIDAR, homePageRequest)) {
			try {
				product.setImageByte(ImageRespositoryImpl.findOne(product.getImageGfs()));
				productsByTypeChuridar.add(product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Product> productsByTypeDress = new ArrayList<Product>();
		for(Product product :productRepository.findByType(Type.DRESS, homePageRequest)) {
			try {
				product.setImageByte(ImageRespositoryImpl.findOne(product.getImageGfs()));
				productsByTypeDress.add(product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<Product> productsByTypeSaree = new ArrayList<Product>();
		for(Product product :productRepository.findByType(Type.SAREE, homePageRequest)) {
			try {
				product.setImageByte(ImageRespositoryImpl.findOne(product.getImageGfs()));
				productsByTypeSaree.add(product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<Type, List<Product>> map = new HashMap<Type, List<Product>>();
		map.put(Type.CHURIDAR, productsByTypeChuridar);
		map.put(Type.DRESS, productsByTypeDress);
		map.put(Type.SAREE, productsByTypeSaree);
		return map;
	}


	public List<Product> getProductsByType(Type type)
			throws vscServiceException {
		final PageRequest homePageRequest = new PageRequest(
				  0, 10, Direction.DESC, "effectiveDate"
				);
		List<Product> products = productRepository.findByType(type, homePageRequest);
		return products;
	}


	public Product getProductById(BigInteger id) throws vscServiceException {
		Product product = productRepository.findOne(id);
		try {
			product.setImageByte(ImageRespositoryImpl.findOne(product.getImageGfs()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

}
