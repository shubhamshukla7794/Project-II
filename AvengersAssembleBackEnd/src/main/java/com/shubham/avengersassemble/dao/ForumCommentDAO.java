package com.shubham.avengersassemble.dao;

import java.util.List;

import com.shubham.avengersassemble.model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(ForumComment forumComment);
	public List<ForumComment> getAllForumComments(int forumId);
}
