package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.CartDetail;

@Repository
public class CartDetailDAOImpl implements CartDetailDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CartDetail getById(long cartid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(CartDetail.class, cartid);
	}

	@Override
	public void saveOrUpdate(CartDetail cartDetail) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartDetail);
	}
	@Override
	public void delete(long cartid) {
		Session session = sessionFactory.getCurrentSession();
		CartDetail cartDetail = getById(cartid);
		session.delete(cartDetail);
	}

}
