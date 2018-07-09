package com.shubham.avengersassemble.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.avengersassemble.dao.UserDetailDAO;
import com.shubham.avengersassemble.model.UserDetail;

public class UserDetailDAOTestCase 
{
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO");
	}
	
	@Test
	public void registerUserTestCase()
	{
		UserDetail user = new UserDetail();
		
		user.setLoginname("Tony");
		user.setPassword("tony@123");
		user.setUsername("Tony Stark");
		user.setEmailid("tony@gmail.com");
		user.setMobile("9876543210");
		user.setRole("ROLE_USER");
		user.setAddress("Malibu, California");
		
		assertTrue("Problem Registering User", userDetailDAO.registerUser(user));
	}
	
	@Test
	public void updateUserTestCase()
	{
		UserDetail user = userDetailDAO.getUser("Peter");
		user.setAddress("Queens, New York");
		
		assertTrue("Problem Updating User", userDetailDAO.updateUser(user));
	}
	
	@Test
	public void validateTestCase()
	{
		UserDetail user = new UserDetail();
		user.setLoginname("Tony");
		user.setPassword("tony@123");
		
		UserDetail userDetail = userDetailDAO.validateUser(user);
		
		assertNotNull("Problem validating User",userDetail);
		
		System.out.println(" Username :  "+userDetail.getUsername());
	}
}