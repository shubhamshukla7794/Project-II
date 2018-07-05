package com.shubham.avengersassemble.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.BlogDAO;
import com.shubham.avengersassemble.model.Blog;


@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO 
{
	@Autowired
	SessionFactory sessionfactory;

	//----------- Adds new Blog -----------
	public boolean addBlog(Blog blog) 
	{
		try
		{
			blog.setCreateDate(new Date());
			sessionfactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Deletes the Blog -----------
	public boolean deleteBlog(Blog blog) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Updates the Blog -----------
	public boolean updateBlog(Blog blog) 
	{
		try
		{
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Gets the Blog based upon Id -----------
	public Blog getBlog(int blogId) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			Blog blog = (Blog) session.get(Blog.class, blogId);
			session.close();
			return blog;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}

	//----------- Lists all the Blogs -----------
	public List<Blog> listBlogs() 
	{
		try
		{
			Session session = sessionfactory.openSession();
			Query query = session.createQuery("from Blog");
			List<Blog> listBlogs = query.list();
			session.close();
			return listBlogs;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}


	//----------- Approves the Blog -----------
	public boolean approveBlog(int blogId) 
	{
		try
		{
			Blog blog = this.getBlog(blogId);
			blog.setStatus("A");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}		
	}


	//----------- Rejects the Blog -----------
	public boolean rejectBlog(int blogId) 
	{
		try
		{
			Blog blog = this.getBlog(blogId);
			blog.setStatus("NA");
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Increase the new Upvote -----------
	public boolean upVote(int blogId) 
	{
		try
		{
			Blog blog = this.getBlog(blogId);
			blog.setUpvotes(blog.getUpvotes()+1);
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Increase the new Downvote -----------
	public boolean downVote(int blogId) 
	{
		try
		{
			Blog blog = this.getBlog(blogId);
			blog.setDownvotes(blog.getDownvotes()+1);
			sessionfactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

}
