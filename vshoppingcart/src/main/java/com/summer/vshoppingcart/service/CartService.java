package com.summer.vshoppingcart.service;

import java.math.BigInteger;
import java.util.Map;

import com.summer.vshoppingcart.domain.Cart;
import com.summer.vshoppingcart.domain.Product;

public interface CartService {
	
	public int addItem(Product item, BigInteger quantity);

	public void removeItem(int itemIndex);

	public Cart getItems();

	/*public int getNumberOfItems();

	public float getCartSubTotal();

	public float getShippingEstimatedCost();

	public float getCartTotal();
*/

}
