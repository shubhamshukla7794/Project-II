package com.shubham.avengersassemble.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.avengersassemble.dao.BlogCommentDAO;
import com.shubham.avengersassemble.model.BlogComment;

public class BlogCommentDAOTestCase 
{
	static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
	}
	
	@Test
	public void addBlogCommentTestCase()
	{
		BlogComment blogComment=new BlogComment();
		blogComment.setBlogId(0);
		blogComment.setLoginname("Hank");
		blogComment.setCommentText("It was suppose to be my Creation");
		
		assertTrue("Problem in Adding a Blog Comment",blogCommentDAO.addComment(blogComment));
	}
	
	
	@Test
	public void listBlogCommentTestCase()
	{
		List<BlogComment> listComments=blogCommentDAO.getAllComments(974);
		
		assertTrue("Problem in Listing BlogComments:",listComments.size()>0);
		
		for(BlogComment blogComment:listComments)
		{
			System.out.print(blogComment.getBlogId()+"-->");
			System.out.println(blogComment.getCommentText()+"\n ----------------------------\n");
		}
	}
}
