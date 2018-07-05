package com.shubham.avengersassemble.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.BlogCommentDAO;
import com.shubham.avengersassemble.model.BlogComment;


@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO
{
	@Autowired
	SessionFactory sessionfactory;

	//----------- Adds new Blog Comment -----------
	public boolean addComment(BlogComment blogComment) 
	{
		try
		{
			blogComment.setCommentDate(new Date());
			sessionfactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Deletes the Blog Comment -----------
	public boolean deleteComment(BlogComment blogComment) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch (Exception e) 
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- List all the Blog Comments -----------
	public List<BlogComment> getAllComments(int blogId) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			Query query = session.createQuery("from BlogComment where blogId=:myblogid");
			query.setParameter("myblogid", blogId);
			List<BlogComment> listBlogComments=query.list();
			return listBlogComments;
		}
		catch (Exception e) 
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}
}
