package main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cart> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Cart c", Cart.class).list();
	}

	@Override
	public Cart getById(long cartid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Cart.class, cartid);
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	@Override
	public void delete(long cartid) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = getById(cartid);
		session.delete(cart);
	}

}
