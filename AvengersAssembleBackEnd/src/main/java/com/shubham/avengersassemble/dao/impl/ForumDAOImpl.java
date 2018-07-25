package com.shubham.avengersassemble.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.ForumDAO;
import com.shubham.avengersassemble.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO 
{
	@Autowired
	SessionFactory sessionfactory;
	
	//----------- Adds new Forum -----------
	public boolean addForum(Forum forum) 
	{
		try
		{
			forum.setCreateDate(new Date());
			sessionfactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}


	//----------- Deletes the Forum -----------
	public boolean deleteForum(Forum forum) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Updates the Forum -----------
	public boolean updateForum(Forum forum) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Gets the Forum based upon Id -----------
	public Forum getForum(int forumId) 
	{
		try
		{
			Session session=sessionfactory.openSession();
			Forum forum =(Forum) session.get(Forum.class, forumId);
			session.close();
			return forum;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}
	
	//----------- Approves the Forum based upon Id -----------
	public boolean approveForum(int forumId) 
	{
		try
		{
			Forum forum = getForum(forumId);
			forum.setStatus("A");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Rejects the Forum based upon Id -----------
	public boolean rejectForum(int forumId) 
	{
		try
		{
			Forum forum = getForum(forumId);
			forum.setStatus("R");
			sessionfactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Lists all the approved Forums -----------
	public List<Forum> approvedForumsList() 
	{
		try
		{
			Session session = sessionfactory.openSession();
			Query query = session.createQuery("from Forum where status = 'A'");
			List<Forum> approvedForumsList = query.list();
			session.close();
			return approvedForumsList;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}

	//----------- Lists all the Forums -----------
	public List<Forum> listForums() 
	{
		try
		{
			Session session = sessionfactory.openSession();
			Query query = session.createQuery("from Forum");
			List<Forum> listForums = query.list();
			session.close();
			return listForums;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}
}
