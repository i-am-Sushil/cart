package com.food.order.cart.model;

import java.util.ArrayList;
import java.util.List;

public class Request {
	private User user;
	private List<Product> products = new ArrayList<>();

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
