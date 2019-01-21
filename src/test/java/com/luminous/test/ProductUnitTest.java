package com.luminous.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luminous.dao.ProductDAO;
import com.luminous.model.Product;

public class ProductUnitTest {

static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.luminous");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("PHILLIPS-Incandescent Lamp");
		product.setProductDesc("3000k warm White,80W");
		product.setPrice(345);
		product.setStock(10);
		product.setCategoryId(3);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}

}
