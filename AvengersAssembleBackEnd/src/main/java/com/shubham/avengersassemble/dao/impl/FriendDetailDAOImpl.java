package com.shubham.avengersassemble.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

	//----------- List Showing Pending Friend Request(s) -----------
	public List<FriendDetail> showPendingFriendRequest(String loginname) 
	{
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from FriendDetail "
				+ "where friendLoginname=:floginname and status = 'NA'");
		query.setParameter("floginname", loginname);
		List<FriendDetail> pendingFriendRequests = query.list();
		return pendingFriendRequests;
	}

	//----------- List Showing Suggested Friend -----------
	public List<UserDetail> showSuggestedFriend(String loginname) 
	{
		return null;
	}

	//----------- Send Friend Request -----------
	public boolean sendFriendRequest(FriendDetail friend) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Accept Friend Request -----------
	public boolean acceptFriendRequest(int friendId) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			FriendDetail friend = (FriendDetail) session.get(FriendDetail.class, friendId);
			friend.setStatus("A");
			session.close();
			sessionfactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Delete Friend Request or Unfriend -----------
	public boolean deleteFriendOrRequest(int friendId) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			FriendDetail friend = (FriendDetail) session.get(FriendDetail.class, friendId);
			session.close();
			sessionfactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

}
