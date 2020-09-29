package com.capgemini.onlinetestmanagementsystem.controller;

import java.math.BigInteger;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.capgemini.onlinetestmanagementsystem.service.IAdminService;
import com.capgemini.onlinetestmanagementsystem.service.ITestService;
import com.capgemini.onlinetestmanagementsystem.util.Util;



@RestController
@RequestMapping("/tests")
public class TestController
{
	
	
	  
	  
	 @Autowired
	 private IAdminService service;
	 
	 /*
	  * This is a GetMethod(Http) is used to view the test.
	  * Method 	  : findTestById
	  * parameters: testId
	  * Returns   : the information added in database
	  * Author 	  : Muskan Ahuja
	  * Date 	  : 26/09/2020
	  */
	 
	 
	 
	 //Find Test By Id Test
	 
	 @GetMapping("/get/{id}")
	  public ResponseEntity<TestDetails>findTestById(@PathVariable("id") BigInteger id)
	  {
		TestEntity test = service.findById(id);
		TestDetails details = Util.convertToTestDetails(test);
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
	    System.out.println(allTests);
	    return allTests;
	   }
	 
	 
	 
	 /*
	  * This is a PostMethod(Http) is used to add the test.
	  * Method 	  : addTest
	  * parameters: testDto
	  * Returns   : the added information of test
	  * Author 	  : Anushka Bhatt
	  * Date 	  : 26/09/2020
	  */
	 
	 
	//Add Test
	 
	 @PostMapping("/add")
	  public ResponseEntity<String>addTest(@RequestBody @Valid TestEntity testEntity)
	  {
	    TestEntity test = service.addTest(testEntity);
	    if (test == null) {
	   	  return new ResponseEntity<String>("Test not added", new HttpHeaders(), HttpStatus.OK);
	   	  } 
	    else 
	    { 
	    	return new ResponseEntity<String>("Test added successfully", new HttpHeaders(), HttpStatus.OK);
	    }
	    }
	    
	    
	    
	 /*
	  * This is a GettMethod(Http) is used to delete the test.
	  * Method 	  : deleteTest
	  * parameters: testId
	  * Author 	  : Muskan Ahuja
	  * Date 	  : 26/09/2020
	  */
	 
	 
	 
	 //Delete Test
	 
	 @GetMapping("/remove/{id}")
	  public ResponseEntity<Boolean> deleteTest(@PathVariable("id") BigInteger testId)
	  {
		TestEntity result = service.deleteTest(testId);
	 
	    ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
		return response;
	   }
	
	 /*
	  * This is a PutMethod(Http) is used to update the test.
	  * Method 	  : updateTest
	  * parameters: testId,testDto
	  * Returns   : the updated test details
	  * Author 	  : Anushka Bhatt
	  * Date 	  : 26/09/2020
	  */
	 
	 
	 
	 
	 //Update Test

	 @PutMapping("/update/{id}")
	  public ResponseEntity<String> updateTest(@PathVariable("id") BigInteger testId) 
	  {
	    TestEntity test =  service.updateTest(testId, test);
		ResponseEntity<TestEntity> response = new ResponseEntity<>(test, HttpStatus.OK);
		return response;
		}
	 
	
		
		
		
	 
}
