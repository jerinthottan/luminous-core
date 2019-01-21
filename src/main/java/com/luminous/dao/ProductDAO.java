package com.luminous.dao;

import java.util.List;

import com.luminous.model.Product;

public interface ProductDAO {

	boolean addProduct(Product product);

	boolean deleteProduct(Product product);

	List<Product> listProducts();

	Product getProduct(int productId);

}
