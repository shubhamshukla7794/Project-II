package com.shubham.avengersassemble.dao;

import com.shubham.avengersassemble.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String loginname);
	public UserDetail validateUser(UserDetail userDetail);
}
