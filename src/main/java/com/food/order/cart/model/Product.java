package com.food.order.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@Column(name="ProductID")
	private Integer productId;
	@Column(name="ProductName")
	private String productName;
	@Column(name="ProductDescription")
	private String productDescription;
	@Column(name="ProductPrice")
	private Double productPrice;

	public Product() {
		// Auto-generated constructor stub
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return productName + "[productId=" + productId + ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + "]";
	}

	/*@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
		return new StringBuilder()
		        .append("productId:"+productId)
		        .append("productName:"+productName)
		        .append("productDescription:"+productDescription)
		        .append("productPrice:"+productPrice)
		        .toString();
	}*/
	
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
