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
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Product p", Product.class).list();
	}

	@Override
	public Product getById(long productId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, productId);
	}

	@Override
	public void saveOrUpdate(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	@Override
	public void delete(long productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = getById(productId);
		session.delete(product);
	}
}
