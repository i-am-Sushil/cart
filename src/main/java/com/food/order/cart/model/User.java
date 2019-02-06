package com.food.order.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "User")
public class User implements Serializable {
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "email", nullable = false, columnDefinition = "VARCHAR(64)")
	private String email;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
