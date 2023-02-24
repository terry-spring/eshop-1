package main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Order;


@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Order> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Order ", Order.class).list();
	}

	@Override
	public Order getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Order.class, id);
	}

	@Override
	public void saveOrUpdate(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = getById(id);
		session.delete(order);
	}

}
