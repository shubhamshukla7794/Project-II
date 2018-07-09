package com.shubham.avengersassemble.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.avengersassemble.dao.ForumDAO;
import com.shubham.avengersassemble.model.Forum;

public class ForumDAOTestCase 
{
	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}
	
	@Test
	public void addForumTestCase()
	{
		Forum forum=new Forum();
		forum.setForumName("Sokovia Accords");
		forum.setForumContent("The Sokovia Accords are a framework for the registration and deployment "
				+ "of enhanced individuals (such as the Avengers) by the collective governments of the "
				+ "world. The bill was presented after the events of the Battle of New York, "
				+ "Infiltration of S.H.I.E.L.D., the Battle of Sokovia and an explosion in Lagos, "
				+ "Nigeria. Every action taken under the Sokovia Accords are ratified by the "
				+ "governments of the United Kingdom, Austria, Germany, Russia, Italy, France, "
				+ "Northern Ireland and the United States of America.");
		forum.setLoginname("Tony");
		forum.setStatus("NA");
		
		assertTrue("Problem in Forum Insertion",forumDAO.addForum(forum));
	}
	
	@Test
	public void deleteForumTestCase()
	{
		Forum forum=forumDAO.getForum(0);
		assertTrue("Problem in Forum Deletion:",forumDAO.deleteForum(forum));
	}
	
	@Test
	public void updateForumTestCase()
	{
		Forum forum=forumDAO.getForum(0);
		
		forum.setForumName("S.H.I.E.L.D. vs HYDRA");
		
		assertTrue("Problem in Forum Updation",forumDAO.updateForum(forum));
	}
	
	@Test
	public void listForumTestCase()
	{
		List<Forum> listForums=forumDAO.listForums();
		assertTrue("Problem in Listing Forum",listForums.size()>0);
		
		for(Forum forum:listForums)
		{
			System.out.print(forum.getForumId()+"\n ----------------------------\n");
			System.out.print(forum.getForumName()+"\n ----------------------------\n");
			System.out.println(forum.getForumContent()+"\n ----------------------------\n");
		}
	}
}