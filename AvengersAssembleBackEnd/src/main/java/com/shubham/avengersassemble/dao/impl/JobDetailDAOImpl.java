package com.shubham.avengersassemble.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.avengersassemble.dao.JobDetailDAO;
import com.shubham.avengersassemble.model.JobDetail;

@Repository("jobDetailDAO")
@Transactional
public class JobDetailDAOImpl implements JobDetailDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	//----------- Adds new Job -----------
	public boolean addJob(JobDetail jobDetail) 
	{
		try
		{
			sessionfactory.getCurrentSession().save(jobDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}
	
	//----------- Deletes the Job -----------
	public boolean deleteJob(JobDetail jobDetail) 
	{
		try
		{
			sessionfactory.getCurrentSession().delete(jobDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Apply for the Job -----------
	public boolean applyForJob(int jobId) 
	{
		try
		{
			JobDetail jobDetail = this.getJob(jobId);
			jobDetail.setApplied(jobDetail.getApplied()+1);
			sessionfactory.getCurrentSession().update(jobDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return false;
		}
	}

	//----------- Gets the Job Details -----------
	public JobDetail getJob(int jobId) 
	{
		try
		{
			Session session = sessionfactory.openSession();
			JobDetail jobDetail = (JobDetail) session.get(JobDetail.class, jobId);
			session.close();
			return jobDetail;
		}
		catch(Exception e)
		{
			System.out.println("Exception Info: "+e);
			return null;
		}
	}

}
