package com.summer.vshoppingcart.service.impl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summer.vshoppingcart.domain.Cart;
import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private Cart cart;
	
	public int addItem(Product product, BigInteger quantity) {
		
		if (cart.getProductCart().containsKey(product)) {
			cart.getProductCart().put(product, cart.getProductCart().get(product).add(quantity));
		} else {
			cart.getProductCart().put(product, quantity);
		}
		cart.getCartSubTotal();
		cart.getCartTotal();
		return 0;
	}

	public void removeItem(int itemIndex) {
		// TODO Auto-generated method stub

	}

	public Cart getItems() {
		// TODO Auto-generated method stub
		return cart;
	}

/*	public int getNumberOfItems() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getCartSubTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getShippingEstimatedCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getCartTotal() {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
