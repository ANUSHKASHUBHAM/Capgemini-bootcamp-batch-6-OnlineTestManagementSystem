package com.capgemini.onlinetestmangementsystem.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmangementsystem.dao.TestAssignToUserRepository;
import com.capgemini.onlinetestmangementsystem.dao.TestRepository;
import com.capgemini.onlinetestmangementsystem.dao.UserRepository;
import com.capgemini.onlinetestmangementsystem.entity.Test;
import com.capgemini.onlinetestmangementsystem.entity.TestAssignToUser;
import com.capgemini.onlinetestmangementsystem.entity.User;
import com.capgemini.onlinetestmangementsystem.exception.ResourceNotFoundException;

@Service
public class TestAssignToUserServiceImpl implements TestAssignToUserService{

	@Autowired
	TestAssignToUserRepository repository;
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public String saveAssignTest(int userId,int testId) throws ResourceNotFoundException {
		Optional<Test> test = testRepository.findById(testId);
		Optional<User> user = userRepository.findById(userId);
		if(test.isPresent())
		{
			if(user.isPresent())
			{
				
				repository.save(new TestAssignToUser(testId,userId));
			}
			else
			{
				return "User Does Not Exist";
			}
		}
		else
		{
			return "Test Does Not Exist";
		}
		
		
	
		return "Test Assign Succesfully";
	}
	

	@Override
	public List<TestAssignToUser> getAllProduct() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<TestAssignToUser> testlist = repository.findAll();
		if(testlist.size()>0)
			return testlist;
		else
			
		return new ArrayList<TestAssignToUser>();
	}

}