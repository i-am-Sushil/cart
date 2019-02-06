package com.food.order.cart.model;

import java.util.List;

public class UserCart {
	private User user;
	private List<Product> products;

	public UserCart(User user, List<Product> products) {
		this.user = user;
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
