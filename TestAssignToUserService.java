package com.capgemini.onlinetestmangementsystem.service;

import java.util.List;

import com.capgemini.onlinetestmangementsystem.entity.TestAssignToUser;
import com.capgemini.onlinetestmangementsystem.exception.ResourceNotFoundException;


public interface TestAssignToUserService {
	
	public String saveAssignTest(int userId,int testId) throws ResourceNotFoundException;

	public List<TestAssignToUser> getAllProduct() throws ResourceNotFoundException;

}