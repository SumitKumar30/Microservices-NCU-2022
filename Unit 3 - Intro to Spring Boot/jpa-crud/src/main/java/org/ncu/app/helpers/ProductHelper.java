package org.ncu.app.helpers;

import java.util.List;

import org.ncu.app.dao.ProductDao;
import org.ncu.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductHelper {
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public long addProduct(Product product) {
		return productDao.addProduct(product);
	}
}
