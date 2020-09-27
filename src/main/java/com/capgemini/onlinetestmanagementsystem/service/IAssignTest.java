package com.capgemini.onlinetestmanagementsystem.service;


import java.util.List;

import com.capgemini.onlinetestmanagementsystem.entity.AssignTestEntity;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;

public interface IAssignTest {

	public String saveAssignTest(AssignTestEntity asstestDetails);

	public List<TestEntity> getTestList(String testTitle);
	
	
}
