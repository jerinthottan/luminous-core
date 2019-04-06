package com.luminous.dao;
import com.luminous.model.Invoice;;
public interface InvoiceDAO {
	public boolean saveOrder(Invoice invoice);
	public boolean updateCart(String username);
}
