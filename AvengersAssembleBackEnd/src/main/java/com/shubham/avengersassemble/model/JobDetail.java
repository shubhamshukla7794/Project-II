package com.shubham.avengersassemble.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="blogidseq",sequenceName="blogidseq")
public class JobDetail 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobidseq")
	private int jobId;
	private String designation;	
	private String rolesandResp;	
	private String company;
	private Date lastDate;	
	private String location;	
	private int ctc;
	private String skills;
	private int applied;
	
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getRolesandResp() {
		return rolesandResp;
	}
	public void setRolesandResp(String rolesandResp) {
		this.rolesandResp = rolesandResp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getApplied() {
		return applied;
	}
	public void setApplied(int applied) {
		this.applied = applied;
	}

}
