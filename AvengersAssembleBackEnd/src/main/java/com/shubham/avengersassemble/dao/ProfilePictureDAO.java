package com.shubham.avengersassemble.dao;

import com.shubham.avengersassemble.model.ProfileImage;

public interface ProfilePictureDAO 
{
	public boolean uploadProfile(ProfileImage profileImg);
	public ProfileImage getProfileImg(String loginname);
}
