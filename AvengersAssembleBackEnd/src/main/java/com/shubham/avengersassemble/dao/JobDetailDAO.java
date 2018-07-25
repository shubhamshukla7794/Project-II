package com.shubham.avengersassemble.dao;

import com.shubham.avengersassemble.model.JobDetail;

public interface JobDetailDAO 
{
	public boolean addJob(JobDetail jobDetail);
	public boolean deleteJob(JobDetail jobDetail);
	public boolean applyForJob(int jobId);
	public JobDetail getJob(int jobId);
}
