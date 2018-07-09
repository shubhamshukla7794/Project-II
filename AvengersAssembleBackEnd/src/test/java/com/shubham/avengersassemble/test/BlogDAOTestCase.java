package com.shubham.avengersassemble.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.avengersassemble.dao.BlogDAO;
import com.shubham.avengersassemble.model.Blog;

public class BlogDAOTestCase 
{
	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}
	
	@Test
	public void addBlogTestCase()
	{
		Blog blog = new Blog();
		blog.setBlogName("Ultron");
		blog.setBlogContent("Ultron was a self-aware, self-teaching, artificial intelligence "
				+ "created and programmed by Tony Stark and Bruce Banner from the Ultron Program "
				+ "and the use of the Chitauri Scepter as part of a peacekeeping force intended to "
				+ "help out the Avengers. Ultron concludes that the only way to ensure peace on Earth "
				+ "is through mankind's immediate extinction.");
		blog.setUpvotes(1);
		blog.setDownvotes(0);
		blog.setLoginname("Coulson");
		blog.setStatus("NA");
		
		assertTrue("Problem in adding blog",blogDAO.addBlog(blog));
	}
	
	@Test
	public void deleteBlogTestCase()
	{
		Blog blog = blogDAO.getBlog(0);
		assertTrue("Problem in deleting blog",blogDAO.deleteBlog(blog));
	}
	
	@Test
	public void updateBlogTestCase()
	{
		Blog blog=blogDAO.getBlog(0);
		
		blog.setBlogName("Loki Invasion");
		blog.setUpvotes(1);
		
		assertTrue("Problem in Blog Updation",blogDAO.updateBlog(blog));
	}
	
	@Test
	public void listBlogTestCase()
	{
		List<Blog> listBlogs=blogDAO.listBlogs();
		assertTrue("Problem in Listing Blog",listBlogs.size()>0);
		
		for(Blog blog:listBlogs)
		{
			System.out.println(blog.getBlogId()+"\n ----------------------------\n");
			System.out.println(blog.getBlogName()+"\n ----------------------------\n");
			System.out.println(blog.getBlogContent()+"\n ----------------------------\n");
		}
	}
	
	@Test
	public void approveBlogTestCase()
	{
		assertTrue("Problem in Approving Blog",blogDAO.approveBlog(0));
	}
	
	@Test
	public void rejectBlogTestCase()
	{
		assertTrue("Problem in Approving Blog",blogDAO.rejectBlog(0));
	}
	
	@Test
	public void upVoteBlogTestCase()
	{
		assertTrue("Problem in Incrementing upVote",blogDAO.upVote(0));
	}
	
	@Test
	public void downVoteBlogTestCase()
	{
		assertTrue("Problem in Incrementing downVote",blogDAO.downVote(0));
	}
}