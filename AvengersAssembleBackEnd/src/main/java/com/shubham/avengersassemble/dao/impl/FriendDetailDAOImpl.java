package com.shubham.avengersassemble.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.FriendDetailDAO;
import com.shubham.avengersassemble.model.FriendDetail;
import com.shubham.avengersassemble.model.UserDetail;


@Repository("friendDetailDAO")
@Transactional
public class FriendDetailDAOImpl implements FriendDetailDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	//----------- Show All Friends of the User -----------
	public List<FriendDetail> showFriends(String loginname) 
	{
		return null;
	}

	public List<FriendDetail> showPendingFriendRequest(String loginname) 
	{
		return null;
	}

	public List<UserDetail> showSuggestedFriend(String loginname) 
	{
		return null;
	}

	public boolean sendFriendRequest(FriendDetail friend) 
	{
		return false;
	}

	public boolean acceptFriendRequest(int friendId) 
	{
		return false;
	}

	public boolean deleteFriendOrRequest(int friendId) 
	{
		return false;
	}

}
