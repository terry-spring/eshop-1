package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.OrderDetail;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public OrderDetail getById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(OrderDetail.class, id);
	}

	@Override
	public void saveOrUpdate(OrderDetail orderDetail) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(orderDetail);
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		OrderDetail orderDetail = getById(id);
		session.delete(orderDetail);
	}

}
