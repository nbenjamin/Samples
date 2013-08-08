package com.summer.vshoppingcart.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigInteger cartSubTotal;
	private BigInteger cartTotal;
	private BigInteger shippingEstimatedCost = BigInteger.valueOf(0);
	
	private Map<Product, BigInteger> productCart = new HashMap<Product, BigInteger>();

	public Map<Product, BigInteger> getProductCart() {
		return productCart;
	}

	public int getNumberOfItems() {
		return productCart.size();
	}

	public BigInteger getCartSubTotal() {
		BigInteger cartSubTotal = BigInteger.valueOf(0);
		for(Entry<Product, BigInteger> entry : productCart.entrySet()) {
			cartSubTotal = cartSubTotal.add( entry.getKey().getPrice().multiply(entry.getValue()));
		}
		this.cartSubTotal = cartSubTotal;
		return this.cartSubTotal;
	}

	public BigInteger getShippingEstimatedCost() {
		return shippingEstimatedCost;
	}

	public BigInteger getCartTotal() {
		this.cartTotal = this.cartSubTotal.add(this.shippingEstimatedCost);
		return this.cartTotal;
	}


}
