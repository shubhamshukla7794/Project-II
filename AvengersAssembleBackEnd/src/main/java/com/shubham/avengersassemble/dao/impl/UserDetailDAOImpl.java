package com.shubham.avengersassemble.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.UserDetailDAO;
import com.shubham.avengersassemble.model.UserDetail;


@Repository("userDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	//----------- Registers new User -----------
	public boolean registerUser(UserDetail userDetail) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}
	
	//----------- Updates the User Details -----------
	public boolean updateUser(UserDetail userDetail) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}
	
	//----------- Get User Details based upon Id -----------
	public UserDetail getUser(String loginname) 
	{
		Session session = sessionfactory.openSession();
		UserDetail userDetail = (UserDetail) session.get(UserDetail.class,loginname);
		session.close();
		return userDetail;
	}
	
	//----------- Validate the Login Details of User -----------
	public UserDetail validateUser(UserDetail userDetail) 
	{
		Session session=sessionfactory.openSession();
		Query query = session.createQuery("from UserDetail where loginname=:myloginname and password=:password");
		query.setParameter("myloginname", userDetail.getLoginname());
		query.setParameter("password",userDetail.getPassword());
		List<UserDetail> listUserDetail = query.list();
		UserDetail userDetail1=listUserDetail.get(0);
		session.close();
		return userDetail1;
	}
}
