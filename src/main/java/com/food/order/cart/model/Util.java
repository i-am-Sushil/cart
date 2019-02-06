package com.food.order.cart.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Util {
	public static void main(String[] args) throws JsonProcessingException {
		Request request = new Request();
		request.setUser(new User("temp name", "temp email"));
		request.setProducts(getProducts());
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(request);
		System.out.println(json);
	}

	private static List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		products.add(createProduct(2, "productName", "productDescription", 11.0));
		products.add(createProduct(3, "productName", "productDescription", 12.0));
		products.add(createProduct(null, "productName", "productDescription", 13.0));
		products.add(createProduct(2, "productName", "productDescription", 14.0));
		return products;
	}

	private static Product createProduct(Integer id, String name, String desc, Double price) {
		Product product = new Product();
		product.setProductName(name);
		product.setProductDescription(desc);
		product.setProductPrice(price);
		return product;
	}
}
