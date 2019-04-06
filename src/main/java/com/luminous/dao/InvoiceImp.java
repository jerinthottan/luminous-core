package com.luminous.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luminous.dao.InvoiceDAO;
import com.luminous.model.Invoice;

@Repository("invoiceDAO")
@Transactional
public class InvoiceImp implements InvoiceDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveOrder(Invoice invoice) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(invoice);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCart(String username) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set PaymentStatuse='paid' where username=:uname");
		query.setParameter("uname", username);
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
			return false;
		
	}
	
	
	
	
}
	

