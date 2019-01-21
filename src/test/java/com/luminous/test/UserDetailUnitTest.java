package com.luminous.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.h2.engine.User;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luminous.dao.UserDAO;
import com.luminous.model.Category;
import com.luminous.model.UserDetail;

public class UserDetailUnitTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.luminous");
		context.refresh();	
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("Tom");
		user.setPassword("user123");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Tom Roy");
		user.setCustomerAddr("Kerala");
		
		assertTrue("Problem in adding User:",userDAO.registerUser(user));
	}
	@Test
	public void listCategoriesTest()
	{
		List<UserDetail> listUserDetail=userDAO.listUserDetails();
		assertTrue("Problem in Listing Categories:",listUserDetail.size()>0);
		
		for(UserDetail user:listUserDetail)
		{
			System.out.println("CustomerName:"+user.getCustomerName());
			System.out.println("CustomerAddress:"+user.getCustomerAddr());
		}
	}
}
