package com.food.order.cart.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.food.order.cart.model.Cart;
import com.food.order.cart.model.Product;
import com.food.order.cart.model.Request;
import com.food.order.cart.model.User;
import com.food.order.cart.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	public Cart getCart(final String email) {
		// TODO call login-with-email service to check if email is registered. Rename
		// login service.
		return cartRepository.getCart(email);
	}

	public Cart addToCart(final Request request) {
		List<String> products = new ArrayList<>();
		Cart cart = getCart(request.getUser().getEmail());
		if (cart == null) {
			cart = new Cart(request.getUser().getEmail(), "");
		} else {
			if(!StringUtils.isEmpty(cart.getProducts())) {
				products = new ArrayList<>(Arrays.asList(cart.getProducts().split(", ")));
			}
		}
		// request.getProducts().forEach(item -> products.add(item.toString()));
		List<Product> validProductsToBeAdded = getValidProducts(request.getProducts());
		for (Product product : validProductsToBeAdded) {
			if(!products.containsAll(Arrays.asList(product.toString().split(", ")))) {
				products.add(product.toString());
			}
		}

		cart.setProducts(String.join(", ", products));
		cartRepository.saveCart(cart);
		return cart;
	}

	public Cart updateCart(final Request request) {
		List<Product> validProducts = getValidProducts(request.getProducts());
		List<String> products = new ArrayList<>();
		validProducts.forEach(item -> products.add(item.toString()));

		Cart cart = new Cart();
		cart.setEmail(request.getUser().getEmail());
		cart.setProducts(String.join(", ", products));
		cartRepository.updateCart(cart);
		return cart;
	}

	public Boolean clearCart(final User user) {
		return cartRepository.clearCart(user);
	}
	
	private List<Product> getValidProducts(List<Product> products) {
		List<Product> validProducts = new ArrayList<>();
		final String catalogueServiceId = "CATALOGUE";
		/*List<ServiceInstance> instances = discoveryClient.getInstances(catalogueServiceId );
		if (instances == null || instances.isEmpty()) {
			System.out.println("No instances for service: " + catalogueServiceId);
			return validProducts;
		}
		for (ServiceInstance serviceInstance : instances) { //for info purpose
			System.out.println("<h3>Instance: " + serviceInstance.getUri() + "</h3>" + "Host: "
					+ serviceInstance.getHost() + "<br>" + "Port: " + serviceInstance.getPort() + "<br>");
		} 
		final String url = instances.get(0).getUri() + "/" + catalogueServiceId.toLowerCase();*/
		  
		/*Application application = eurekaClient.getApplication(catalogueServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/catalogue";*/
		String url = "http://13.233.214.243:8083/catalogue";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<List<Product>> response = null;
		try {
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        response = restTemplate.exchange(url, HttpMethod.GET, entity,  new ParameterizedTypeReference<List<Product>>(){});
	        
	    }
	    catch (Exception ex) {
	        System.out.println("** Exception: "+ ex.getMessage());
	    }
		if(response != null && response.getBody() != null) {
			List<Product> catalogue = response.getBody();
			
			for(Product product : products) {
				for(Product catalogueProduct : catalogue) {
					if(product.getProductId().equals(catalogueProduct.getProductId())) {
						validProducts.add(catalogueProduct);
						break;
					}
				}
			}
		}
		
		return validProducts;
	}
	
	/*public static void main(String[] args) {
		List<Product> products  =new ArrayList<>();
		Product product1 =new Product();
		product1.setProductId(3);
		products.add(product1);
		
		Product product2 =new Product();
		product2.setProductId(8);
		products.add(product2);
		
		CartService cartService = new CartService();
		cartService.getValidProducts(products);
	}*/

}
