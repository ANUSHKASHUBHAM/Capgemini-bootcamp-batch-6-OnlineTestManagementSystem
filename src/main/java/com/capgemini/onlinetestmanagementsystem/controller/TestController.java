package com.capgemini.onlinetestmanagementsystem.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;


import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagementsystem.dto.TestDetails;
import com.capgemini.onlinetestmanagementsystem.dto.TestDto;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.entity.User;
import com.capgemini.onlinetestmanagementsystem.service.ITestService;
import com.capgemini.onlinetestmanagementsystem.util.Util;



@RestController
@RequestMapping("/tests")
public class TestController
{
	
	 private static final Logger Log= LoggerFactory.getLogger(TestController.class);
	  
	  
	 @Autowired
	 private ITestService service;
	 
	 
	 //Find Test By Id Test
	 
	 @GetMapping("/get/{id}")
	  public ResponseEntity<TestDetails>findTestById(@PathVariable("id") BigInteger id)
	  {
		TestEntity test = service.findById(id);
		TestDetails details = Util.convertToTestDetails(test);
		Log.info("Test Fetched");
		ResponseEntity<TestDetails>response=new ResponseEntity<>(details, HttpStatus.OK);
		System.out.println("This is detail"+details);
		return response;
		
	  }
	 
	 //Fetch All Test
	 
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	  public List<TestDto>fetchAll()
	  {
	    List<TestEntity> tests=service.fetchAll();
	    List<TestDto> allTests=Util.tests(tests);
	    Log.info("All Tests Fetched");
	    System.out.println(allTests);
	    return allTests;
	   }
	 
	 
	//Add Test
	 
	 @PostMapping("/add")
	  public ResponseEntity<TestEntity>addTest(@RequestBody @Valid TestDto testDto)
	  {
	    TestEntity test = Util.convertFromDto(testDto);
	    test=service.addTest(test);
	    Log.info("Test created ");
	    ResponseEntity<TestEntity>response=new ResponseEntity<>(test, HttpStatus.OK);
	    System.out.println(testDto);
	    return response;
	      
	   }
	 
	 //Delete Test
	 
	 @GetMapping("/remove/{id}")
	  public ResponseEntity<Boolean> deleteTest(@PathVariable("id") BigInteger testId)
	  {
		TestEntity result = service.deleteTest(testId);
	    Log.info("Test removed");
	    ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
		return response;
	   }
	
	 
	 //Update Test

	 @PutMapping("/update/{id}")
	  public ResponseEntity<TestEntity> updateTest(@PathVariable("id") BigInteger testId, @RequestBody @Valid TestDto testDto) 
	  {
	    TestEntity test = Util.convertFromDto(testDto);
		test.setTestId(testId);
		test = service.updateTest(testId, test);
		Log.info("Test updated ");
		ResponseEntity<TestEntity> response = new ResponseEntity<>(test, HttpStatus.OK);
		return response;
		}
	 
	
		
		
		
	 
}
