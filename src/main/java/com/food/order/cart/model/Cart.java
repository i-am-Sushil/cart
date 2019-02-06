package com.food.order.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@Column(name = "email", nullable = false, columnDefinition = "VARCHAR(64)")
	private String email;
	@Column(name = "products", length=10000)
	private String products;

	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Cart(String email, String products) {
		this.email = email;
		this.products = products;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProducts() {
		return products != null ? products : "";
	}

	public void setProducts(String products) {
		this.products = products;
	}
	
	/*@Override
	public String toString() {
		//return new com.google.gson.Gson().toJson(this);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json= ow.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}*/

}
