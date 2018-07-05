package com.shubham.avengersassemble.dao;

import java.util.List;

import com.shubham.avengersassemble.model.Blog;

public interface BlogDAO 
{
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public Blog getBlog(int blogId);
	
	public List<Blog> listBlogs();
	
	public boolean approveBlog(int blogId);
	public boolean rejectBlog(int blogId);
	
	public boolean upVote(int blogId);
	public boolean downVote(int blogId);
}
