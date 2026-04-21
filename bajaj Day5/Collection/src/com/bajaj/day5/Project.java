package com.bajaj.day5;

import java.util.ArrayList;
import java.util.Date;

public class Project {
	private String name;
	private String Manager;
	private ArrayList<String> member ;
	private Date job;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return Manager;
	}
	public void setManager(String manager) {
		Manager = manager;
	}
	public ArrayList<String> getMember() {
		return member;
	}
	public void setMember(ArrayList<String> member) {
		this.member = member;
	}
	public Date getJob() {
		return job;
	}
	public void setJob(Date job) {
		this.job = job;
	}
	public Project(String name, String manager, ArrayList<String> member, Date job) {
	
		this.name = name;
		Manager = manager;
		this.member = member;
		this.job = job;
	}
	@Override
	public String toString() {
		return "Project [name=" + name + ", Manager=" + Manager + ", member=" + member + ", job=" + job + "]";
	}
	
	
	
	
	
	
	
	
	
	
 
}
