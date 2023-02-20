package main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product", Product.class).list();
	}

	@Override
	@Transactional
	public Product getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = getById(id);
		session.delete(product);
	}
}
