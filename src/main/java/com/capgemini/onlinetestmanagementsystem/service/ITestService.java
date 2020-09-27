package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;





public interface ITestService {
	
	TestEntity addTest(TestEntity test);

	TestEntity updateTest(BigInteger testId, TestEntity test);

	TestEntity deleteTest(BigInteger testId);

	List<TestEntity> fetchAll();

	TestEntity findById(BigInteger testId);
}
