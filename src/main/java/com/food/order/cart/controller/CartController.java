package com.food.order.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.order.cart.model.Cart;
import com.food.order.cart.model.Request;
import com.food.order.cart.model.User;
import com.food.order.cart.service.CartService;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/cart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cart getCart(@RequestParam final String email) {
		System.out.println("CartController.getCart()");
		return cartService.getCart(email);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cart addToCart(@RequestBody final Request request) {
		System.out.println("CartController.addToCart()");
		return cartService.addToCart(request);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cart updateCart(@RequestBody final Request request) {
		System.out.println("CartController.removeFromCart()");
		return cartService.updateCart(request);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Boolean clearCart(@RequestBody final User user) {
		System.out.println("CartController.clearCart()");
		return cartService.clearCart(user);
	}
}
