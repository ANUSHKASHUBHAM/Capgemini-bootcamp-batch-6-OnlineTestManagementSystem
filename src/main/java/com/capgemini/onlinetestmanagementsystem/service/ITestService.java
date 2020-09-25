package com.capgemini.onlinetestmanagementsystem.service;



import com.capgemini.onlinetestmanagementsystem.entity.TestManagement;

import java.util.List;


public interface ITestService
{
	TestManagement addTest(TestManagement test);

	TestManagement updateTest( TestManagement test);

	TestManagement deleteTest(Integer testId);
	
	List<TestManagement> fetchAll();

	TestManagement findById(Integer testId);
}
