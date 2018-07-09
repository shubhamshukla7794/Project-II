package com.shubham.avengersassemble.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.avengersassemble.dao.ForumCommentDAO;
import com.shubham.avengersassemble.model.ForumComment;



public class ForumCommentDAOTestCase 
{
	static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		forumCommentDAO = (ForumCommentDAO) context.getBean("forumCommentDAO");
	}
	
	@Test
	public void addForumCommentTestCase()
	{
		ForumComment forumComment=new ForumComment();
		forumComment.setForumId(0);
		forumComment.setLoginname("Steve");
		forumComment.setDiscussionText("I don't agree with this.");
		
		assertTrue("Problem in Adding a Forum Comment",forumCommentDAO.addForumComment(forumComment));
	}
	
	@Test
	public void listForumCommentTestCase()
	{
		List<ForumComment> listComments=forumCommentDAO.getAllForumComments(0);
		
		assertTrue("Problem in Listing ForumComments:",listComments.size()>0);
		
		for(ForumComment forumComment:listComments)
		{
			System.out.print(forumComment.getForumId()+"-->");
			System.out.println(forumComment.getDiscussionText()+"\n ----------------------------\n");
		}
	}
}
