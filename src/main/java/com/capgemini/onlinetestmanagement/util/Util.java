package com.capgemini.onlinetestmanagement.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.onlinetestmanagement.dto.TestDetails;
import com.capgemini.onlinetestmanagement.dto.TestDto;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;




public class Util {
	
	public static TestDto testDto(TestEntity test) {
		TestDto dto=new TestDto();
		dto.setTestId(test.getTestId());
		dto.setTestTitle(test.getTestTitle());
		dto.setTestDuration(test.getTestDuration());
		dto.setTestTotalMarks(test.getTestTotalMarks());
		//dto.setStartTime(test.getStartTime());
		//dto.setEndTime(test.getEndTime());
		return dto;
	}
	
	public static List<TestDto>tests(List<TestEntity>tests){
		List<TestDto>allTests=new ArrayList<>();
		for(TestEntity test:tests) {
			TestDto dto=testDto(test);
			allTests.add(dto);
		}
		return allTests;
	}
	
	public static TestDetails convertToTestDetails(TestEntity test){
		TestDetails details = new TestDetails();
		
		
		details.setTestId(test.getTestId());
		details.setTestTitle(test.getTestTitle());
		details.setEndTime(test.getEndTime());
//		details.setStartTime(test.getStartTime());
//		details.setTestDuration(test.getTestDuration());
		details.setTestTotalMarks(test.getTestTotalMarks());
		//details.setTestMarksScored(test.getTestMarksScored());
		return details;
	}
	
	
	 
	 public static TestEntity  convertFromDto(TestDto dto) {
			TestEntity test = new TestEntity();
			
			//test.setEndTime(dto.getEndTime());
			//test.setStartTime(dto.getStartTime());
			test.setTestDuration(dto.getTestDuration());
			//test.setTestMarksScored(dto.getTestMarksScored());
			test.setTestTitle(dto.getTestTitle());
			test.setTestTotalMarks(dto.getTestTotalMarks());
			return test;
		}
	 

}
