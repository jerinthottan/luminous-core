package com.luminous.dao;

import java.util.List;

import com.luminous.model.Category;
import com.luminous.model.UserDetail;

public interface UserDAO {
	
	boolean updateAddress(UserDAO user);

	UserDAO getUser(String username);

	boolean registerUser(UserDetail user);

	List<UserDetail> listUserDetails();
}
