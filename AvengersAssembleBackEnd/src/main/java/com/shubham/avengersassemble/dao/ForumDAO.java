package com.shubham.avengersassemble.dao;

import java.util.List;

import com.shubham.avengersassemble.model.Forum;

public interface ForumDAO 
{
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int forumId);
	public boolean approveForum(int forumId);
	public boolean rejectForum(int forumId);
	
	public List<Forum> approvedForumsList();
	public List<Forum> listForums();
}
