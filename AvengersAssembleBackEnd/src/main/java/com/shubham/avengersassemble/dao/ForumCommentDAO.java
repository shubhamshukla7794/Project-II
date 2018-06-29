package com.shubham.avengersassemble.dao;

import java.util.List;

import com.shubham.avengersassemble.model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addForumComment(ForumComment blogComment);
	public boolean deleteForumComment(ForumComment blogComment);
	public List<ForumComment> getAllForumComments(int blogId);
}
