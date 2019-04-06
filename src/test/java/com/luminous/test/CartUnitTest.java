package com.luminous.test;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luminous.dao.CartDAO;

import com.luminous.model.Cart;

public class CartUnitTest {

	@Autowired
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.luminous");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(2);
		cart.setProductName("Lenova core");
		cart.setQuantity(1);
		cart.setPrice(4500);
		cart.setPaymentStatuse("NO");
		cart.setUsername("venky");
		
		assertTrue("Problem in Adding Cart" , cartDAO.addCart(cart));
	}
	
	
	@Test
	public void displayCart()
	{
		List<Cart> listCart=cartDAO.listCart("luminous");
		assertTrue("Problem in Display the Cart" , listCart.size()>0);
		for(Cart cart:listCart)
		{
			System.out.print(cart.getProductId()+"\t");
			System.out.print(cart.getProductName()+"\t");
			System.out.print(cart.getPrice()+"\t");
			System.out.print(cart.getPrice()*cart.getQuantity());
		}
		
	
	}
	}

