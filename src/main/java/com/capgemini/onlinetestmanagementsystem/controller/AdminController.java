package com.capgemini.onlinetestmanagementsystem.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capgemini.onlinetestmanagementsystem.entity.Admin;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.service.IAdminService;


@RequestMapping("/onlinetestmanagementsystem")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	/*
	  * This is a GetMethod(Http) is used to check the authorization of Name and Password from Database.
	  * Method 	  : loginAdmin
	  * Type 	  : Admin
	  * parameters: Admin
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@PostMapping("/admins")
	public Admin loginCustomer(@RequestBody Admin admin) {
		String adminName= admin.getAdminName();
		String adminPassword=admin.getAdminPassword();
		return adminService.loginAdmin(adminName, adminPassword);
	}

	/*
	  * This is a GetMethod(Http) used to get the Admin Details using Admin Id from Database.
	  * Method 	  : getAdmin
	  * Type 	  : Admin
	  * parameters: the adminId is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@GetMapping("/getAdmin/adminid/{adminId}")
	public ResponseEntity<Admin> getAdmin(@PathVariable String adminId)
	{
		//Calling the service for getting the Admin using ID.
		return new ResponseEntity<Admin>(adminService.getAdmin(adminId),HttpStatus.OK);
	}
	

	/*
	  * This is a DeleteMethod(Http) used to delete the Admin Details using Admin Id from Database.
	  * Method 	  : deleteAdmin
	  * Type 	  : String
	  * parameters: the adminId is of String type
	  * Returns   : String
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@DeleteMapping("/adminid/{adminId}")
	public String deleteAdmin(@PathVariable String adminId) {
		adminService.deleteAdmin(adminId);
		return "Admin with id " + adminId + " Removed Successfully";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
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
	  public ResponseEntity<TestEntity>findTestById(@PathVariable("id") BigInteger id)
	  {
		return new ResponseEntity<TestEntity>(adminService.findById(id),HttpStatus.OK);
		
	  }

	 
	 //Fetch All Test
	 
	 
	 
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	 public List<TestEntity>fetchAll()
	 
	 {
		 List<TestEntity> testEntity=adminService.fetchAll();
		 
		return testEntity;
		 
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
	    TestEntity test = adminService.addTest(testEntity);
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
	  public ResponseEntity<String> deleteTest(@PathVariable("id") BigInteger testId)
	  {
		TestEntity result = adminService.deleteTest(testId);
	 
		if (result == null) {
			return new ResponseEntity<String>("Delete operation is unsuccessful", new HttpHeaders(), HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Delete operation is successful", new HttpHeaders(), HttpStatus.OK);
		}
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
	  public ResponseEntity<String> updateTest(@PathVariable("id") BigInteger testId, TestEntity test) 
	  {
	    TestEntity test1 =  adminService.updateTest(testId, test);
	    if (test1 == null) {
		   	  return new ResponseEntity<String>("Test not added", new HttpHeaders(), HttpStatus.OK);
		   	  } 
		    else 
		    { 
		    	return new ResponseEntity<String>("Test added successfully", new HttpHeaders(), HttpStatus.OK);
		    }
		}
	
		
	
	

}
