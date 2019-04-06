package com.luminous.dao;

import java.util.List;

import com.luminous.model.Product;
import com.luminous.model.Supplier;

public interface ProductDAO {

	boolean addProduct(Product product);

	boolean deleteProduct(Product product);

	boolean updateProduct(Product product);
	
	List<Product> listProducts();

	Product getProduct(int productId);

}
