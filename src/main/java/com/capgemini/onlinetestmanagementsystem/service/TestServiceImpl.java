package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinetestmanagementsystem.dao.ITestDao;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;

import com.capgemini.onlinetestmanagementsystem.exception.TestNotFoundException;


@Service
@Transactional
public class TestServiceImpl implements ITestService {
   
   @Autowired
	private ITestDao testDao;
	
	
	/*
	 ***************************************************
	 *This method is used to add new test
	 *************************************************** 
	 */
	
	@Override
	public TestEntity addTest(TestEntity test) 
	{	
			test = testDao.save(test);
			return test;
	}
	
	/*
	 ***************************************************
	 *This method is used to update existing test
	 *************************************************** 
	 */
	

	@Override
	public TestEntity updateTest(BigInteger testId, TestEntity test) 
	{
		boolean exists = testDao.existsById(testId);
		if (exists)
		{
			test = testDao.save(test);
			return test;
		}
		throw new TestNotFoundException("Test not found for id="+testId);
	}
	
	/*
	 ***************************************************
	 *This method is used to delete existing test
	 *************************************************** 
	 */

	@Override
	public TestEntity deleteTest(BigInteger testId) 
	{
		TestEntity test = findById(testId);
		testDao.delete(test);
		return test;
	}
	
	
	/*
	 ***************************************************
	 *This method is used to find test byId
	 *************************************************** 
	 */



	@Override
	public TestEntity findById(BigInteger testId)
	{
		 Optional<TestEntity>optional=testDao.findById(testId);
	     if(optional.isPresent())
	     {
	         TestEntity test=optional.get();
	         return test;
	     }
	     throw new TestNotFoundException("Test not found for id="+testId);
	    }
	
	/*
	 ***************************************************
	 *This method is used to fetch All test
	 *************************************************** 
	 */
	@Override
	public List<TestEntity> fetchAll() 
	{
		List<TestEntity> tests = testDao.findAll();
		return tests;
	}
	}


