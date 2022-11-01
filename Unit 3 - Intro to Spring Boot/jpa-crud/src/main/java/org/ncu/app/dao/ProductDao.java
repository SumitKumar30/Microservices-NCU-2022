package org.ncu.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.ncu.app.models.Product;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Product> getAllProducts() {
		List<Product> products = entityManager.createQuery("select p from Product p", Product.class).getResultList();
		return products;
	}
	
	public long addProduct(Product product) {
		entityManager.persist(product);
		return product.getId();
	}
}
