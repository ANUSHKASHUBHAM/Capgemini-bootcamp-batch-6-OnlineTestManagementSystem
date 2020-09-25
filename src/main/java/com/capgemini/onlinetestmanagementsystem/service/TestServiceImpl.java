package com.capgemini.onlinetestmanagementsystem.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinetestmanagementsystem.dao.ITestDao;
import com.capgemini.onlinetestmanagementsystem.entity.TestManagement;
import com.capgemini.onlinetestmanagementsystem.exception.TestNotFoundException;

@Service
@Transactional
public class TestServiceImpl implements ITestService
{

	private ITestDao testDao;

	public ITestDao getTestDao() 
	{
		return testDao;
	}

	@Autowired
	public void setTestDao(ITestDao testDao)
	{
		this.testDao = testDao;
	}
	@Override
	public TestManagement addTest(TestManagement test)
	{
		test = testDao.save(test);
		return test;
	}

	@Override
	public TestManagement updateTest(TestManagement test) {
		boolean exists = testDao.existsById(test.getTestId());
		if (exists) {
			test = testDao.save(test);
			return test;
		}
		throw new TestNotFoundException("Test not found for id="+test.getTestId());
	}

	@Override
	public TestManagement deleteTest(Integer testId) 
	{
		TestManagement test = findById(testId);
		testDao.delete(test);
		return test;
	}

	@Override
	public List<TestManagement> fetchAll()
	{
		List<TestManagement> tests = testDao.findAll();
		return tests;
	}

	@Override
	public TestManagement findById(Integer testId)
	{
		Optional<TestManagement> optional = testDao.findById(testId);
		if (optional.isPresent())
		{
			TestManagement test = optional.get();
			return test;
		}
		throw new TestNotFoundException("Test not found for id=" + testId);
	}
 
}
