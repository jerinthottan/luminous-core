package com.luminous.dao;

import java.util.List;

import com.luminous.model.UserDetail;

public interface UserDAO {
	public boolean registerUser(UserDetail user);
	public boolean updateAddress(UserDetail user);
	
	public UserDetail getUser(String username);
	public List<UserDetail> listUserDetails();


}
