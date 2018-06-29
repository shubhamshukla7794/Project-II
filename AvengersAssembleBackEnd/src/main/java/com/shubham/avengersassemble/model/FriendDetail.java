package com.shubham.avengersassemble.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="friendidseq",sequenceName="friendidseq")
public class FriendDetail 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendidseq")
	int friendId;
	String loginname;
	String friendLoginname;	
	String status;
	
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFriendLoginname() {
		return friendLoginname;
	}
	public void setFriendLoginname(String friendLoginname) {
		this.friendLoginname = friendLoginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
