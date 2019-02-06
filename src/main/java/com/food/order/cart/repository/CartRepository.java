package com.food.order.cart.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.order.cart.model.Cart;
import com.food.order.cart.model.User;

@Repository
public class CartRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Cart getCart(final String email) {
		final Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, email);
		return cart;
	}

	public Boolean saveCart(final Cart cart) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(cart);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return Boolean.FALSE;
		} finally {
			session.close();
		}
		return Boolean.TRUE;
	}

	public Boolean updateCart(final Cart cart) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(cart);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			return Boolean.FALSE;
		} finally {
			session.close();
		}
		return Boolean.TRUE;
	}

	public Boolean clearCart(final User user) {
		Cart cart = new Cart();
		cart.setEmail(user.getEmail());
		updateCart(cart);
		return Boolean.TRUE;
	}

}
