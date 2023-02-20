package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ProductDAO;
import main.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO prouctDao;
	
	@Override
	public List<Product> getAll() {
		return prouctDao.getAll();
	}

	@Override
	public Product getById(int productId) {
		return prouctDao.getById(productId);
	}

	@Override
	public void saveOrUpdate(Product product) {
		prouctDao.saveOrUpdate(product);
	}

	@Override
	public void delete(int productId) {
		prouctDao.delete(productId);
	}
}
