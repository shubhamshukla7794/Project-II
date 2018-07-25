package com.shubham.avengersassemble.dao.impl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.ProfilePictureDAO;
import com.shubham.avengersassemble.model.ProfileImage;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	//----------- Saves the ProfilePic -----------
	public boolean uploadProfile(ProfileImage profileImg) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			session.saveOrUpdate(profileImg);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Gets the ProfilePic -----------
	public ProfileImage getProfileImg(String loginname) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			ProfileImage profileImage = (ProfileImage) session.get(ProfileImage.class, loginname);
			session.close();
			return profileImage;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}

}
