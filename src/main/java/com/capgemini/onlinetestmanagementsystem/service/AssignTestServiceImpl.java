package com.capgemini.onlinetestmanagementsystem.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.onlinetestmanagementsystem.dao.AssignTestRepository;
import com.capgemini.onlinetestmanagementsystem.dao.TestRepository;
import com.capgemini.onlinetestmanagementsystem.dao.UserRepository;

import com.capgemini.onlinetestmanagementsystem.entity.AssignTestEntity;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.entity.UserEntity;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;


public class AssignTestServiceImpl implements IAssignTest{

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AssignTestRepository assignTestRepository;
	@Override
	public String saveAssignTest(AssignTestEntity asstestdetails) {
		// TODO Auto-generated method stub
		
		TestEntity testDetails = null;
		UserEntity userDetails = null;
		try {
			testDetails = testRepository.findById(asstestdetails.getTestId())
					.orElseThrow(() -> new ResourceNotFoundException("Test Does not exist " ));
		
			userDetails = userRepository.findById(asstestdetails.getUserId())
					.orElseThrow(() -> new ResourceNotFoundException("User Does not exist " ));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assignTestRepository.save(asstestdetails);
		
		userDetails.setUserTest(testDetails);
		userRepository.updateUser(testDetails, asstestdetails.getUserId());
			
		return "Assign Test Successfull";
	}
	
	
	@Override
	public List<TestEntity> getTestList(String testTitle) {
		// TODO Auto-generated method stub
		
		List<TestEntity> testList = testRepository.findByKeyword(testTitle);
	

		return testList;
	}


	
	

}
