package com.luminous.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.dao.UserDAO;
import com.luminous.model.Category;
import com.luminous.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDetailDAOImp implements UserDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	

	public boolean registerUser(UserDetail user) {

		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;	
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateAddress(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	 public UserDetail getUser(String username) 
		{
		Session session=sessionFactory.openSession();
		UserDetail userdetail=session.get(UserDetail.class,username);	
		session.close();
		return userdetail;
		}

	public List<UserDetail> listUserDetails() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> listUserDetails=query.list();
		session.close();
		return listUserDetails;
	}
	
	
}