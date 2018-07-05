package com.shubham.avengersassemble.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.ForumCommentDAO;
import com.shubham.avengersassemble.model.ForumComment;


@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	//----------- Adds new Forum Comment -----------
	public boolean addForumComment(ForumComment forumComment) 
	{
		try
		{
			forumComment.setDiscussionDate(new Date());
			sessionfactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Deletes the Forum Comment -----------
	public boolean deleteForumComment(ForumComment forumComment) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- List all the Forum Comments -----------
	public List<ForumComment> getAllForumComments(int forumId) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			Query query = session.createQuery("from ForumComment where forumId=:myforumId");
			query.setParameter("myforumId", forumId);
			List<ForumComment> listForumComments=query.list();
			return listForumComments;
		}
		catch (Exception e) 
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}	
}
