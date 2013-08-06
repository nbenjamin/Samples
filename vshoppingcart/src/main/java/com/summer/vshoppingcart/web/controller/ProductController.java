package com.summer.vshoppingcart.web.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.domain.Type;
import com.summer.vshoppingcart.service.ProductService;
import com.summer.vshoppingcart.service.impl.vscServiceException;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products/{type}/more", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String viewProductDetails(@PathVariable("type") String type,
			Model model) {
		try {
			model.addAttribute("productsByType",
					productService.getProductsByType(Type.forName(type)));
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/products/ProductListsByType";
	}

	@RequestMapping(value = "/products/addnew")
	public String saveProducts(final Product product,
			final BindingResult bindingResult) {
		if (!StringUtils.isEmpty(product.getName())) {
			try {
				productService.saveProduct(product);
				return "/products/ProductSuccess";
			} catch (vscServiceException e) {
				return "/products/AddProducts";
			}
		}
		return "/products/AddProducts";
	}

	@RequestMapping(value = "/products/ProductSuccess", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String redirectProductResponse(Product product,
			BindingResult result, Model model) {
		return "/products/ProductSuccess";
	}
	
	@RequestMapping(value = "/products/view/{id}" )
	public String viewProducts(@PathVariable("id") BigInteger id, Model model) {
		Product product = null;
		try {
			product = productService.getProductById(id);
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute(product);
		return "products/product";
	}

	@RequestMapping(value = "/products/ListProducts",method = RequestMethod.GET)
	public String getProducts(Model model) {
		List<Product> products = null;
		try {
			products = productService.getAllProducts();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("products", products);
		return "/products/ListProducts";
	}

	@RequestMapping(value = "/products/photos", headers = "Accept=*/*", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage() throws IOException {
/*
		List<Product> products = null;
		try {
			products = productService.getAllProducts();
			
			 HttpHeaders headers = new HttpHeaders();
			 headers.setContentType(MediaType.IMAGE_JPEG);
			 
		} catch (vscServiceException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		products.get(0);
		return products.get(0).getImageByte();
*/
	 return null;
	}

	@ModelAttribute("allTypes")
	public List<Type> populateTypes() {
		return Arrays.asList(Type.ALL);
	}

	@ModelAttribute("latestProducts")
	public Map<Type, List<Product>> getLatestProductsByType() {
		Map<Type, List<Product>> map = new HashMap<Type, List<Product>>();
		try {
			map = productService.getLatestProducts();
		} catch (vscServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
