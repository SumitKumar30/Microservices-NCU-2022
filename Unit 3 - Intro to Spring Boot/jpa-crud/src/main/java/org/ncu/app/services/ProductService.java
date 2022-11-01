package org.ncu.app.services;

import java.util.List;

import org.ncu.app.helpers.ProductHelper;
import org.ncu.app.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductHelper productHelper;
	
	public List<Product> getAllProducts() {
		return productHelper.getAllProducts();
	}
	
	public String addProduct(Product product) {
		return productHelper.addProduct(product) != 0 ? "Product Added!":"Product Not Added!";
	}
}
