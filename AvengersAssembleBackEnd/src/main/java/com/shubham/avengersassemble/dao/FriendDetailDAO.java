package com.shubham.avengersassemble.dao;

import java.util.List;

import com.shubham.avengersassemble.model.FriendDetail;
import com.shubham.avengersassemble.model.UserDetail;

public interface FriendDetailDAO 
{
	public List<FriendDetail> showFriends(String loginname);
	public List<FriendDetail> showPendingFriendRequest(String loginname);
	public List<UserDetail> showSuggestedFriend(String loginname);
	public boolean sendFriendRequest(FriendDetail friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendOrRequest(int friendId);
	
}
