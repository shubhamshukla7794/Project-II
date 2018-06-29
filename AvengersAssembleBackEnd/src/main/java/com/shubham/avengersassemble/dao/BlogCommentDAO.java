package com.shubham.avengersassemble.dao;

import java.util.List;

import com.shubham.avengersassemble.model.BlogComment;

public interface BlogCommentDAO 
{
	public boolean addComment(BlogComment blogComment);
	public boolean deleteComment(BlogComment blogComment);
	public List<BlogComment> getAllComments(int blogId);
}
