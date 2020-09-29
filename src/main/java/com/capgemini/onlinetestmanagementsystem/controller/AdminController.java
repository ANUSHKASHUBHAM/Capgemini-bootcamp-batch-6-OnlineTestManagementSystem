package com.capgemini.onlinetestmanagementsystem.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
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

import com.capgemini.onlinetestmanagementsystem.entity.Question;
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
	  * This is a postMethod(Http) is used to add the test.
	  * Method 	  : addTest
	  * parameters: testEntity
	  * Returns   : the information added in database
	  * Author 	  : Anushka bhatt
	  * Date 	  : 26/09/2020
	  */
	@PostMapping("/add")
	public ResponseEntity<TestEntity>addTest(@RequestBody @Valid TestEntity testEntity )
	{
		TestEntity test1=convertFromTestEntity(testEntity);
		TestEntity myTest=adminService.addTest(test1);
		 
		  System.out.println(myTest);
		ResponseEntity<TestEntity>response=new ResponseEntity<TestEntity>(myTest, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<TestEntity> updateTest(@PathVariable("id") BigInteger TestId, @RequestBody @Valid TestEntity testEntity) {
		TestEntity test1=convertFromTestEntity(testEntity);
		test1.setTestId(TestId);
		testEntity = adminService.updateTest(TestId, test1);
		 
		ResponseEntity<TestEntity> response = new ResponseEntity<>(testEntity, HttpStatus.OK);
		return response;
	}
	
	 @GetMapping("/remove/{id}")
		public ResponseEntity<Boolean> deleteTest(@PathVariable("id") BigInteger testId) {
			TestEntity result = adminService.deleteTest(testId);
			ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
			return response;
		}

	 
	 @GetMapping("/get/{id}")
	 public ResponseEntity<TestEntity>getTest(@PathVariable("id") BigInteger testId){
			TestEntity testEntity = adminService.findById(testId);
			TestEntity myTest=convertFromTestEntity(testEntity);
			ResponseEntity<TestEntity>response=new ResponseEntity<>(myTest, HttpStatus.OK);
			return response;
			
		  }
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	 	public List<TestEntity>fetchAll(){
		 List<TestEntity> testEntity=adminService.fetchAll();
		 System.out.println(testEntity);
		 return testEntity;
	 }
	 public TestEntity convertFromTestEntity(TestEntity testEntity) {
			TestEntity test=new TestEntity();
			 test.setTestId(testEntity.getTestId());
			 test.setTestTitle(testEntity.getTestTitle());
			 test.setTestDuration(testEntity.getTestDuration());
			 test.setTestTotalMarks(testEntity.getTestTotalMarks());
			 test.setTestMarksScored(testEntity.getTestMarksScored());
			 test.setStartTime(testEntity.getStartTime());
			 test.setEndTime(testEntity.getEndTime());
			 
			return  test;
		}
	 	
	 	 
	 
	
	
	 
	 
	 
	
	
	@GetMapping("/question")
	public List<Question> getAllQuestions() {
		return adminService.getAllQuestion();
	}

	@GetMapping("/question/{sno}")
	public ResponseEntity<Question> getQuestionById(@PathVariable int Sno)
	{
		return ResponseEntity.ok().body(adminService.getQuestionBySno(Sno));
	}

	@PostMapping(path="/question",consumes="application/json",produces="application/json")
	public Question createQuestion(@RequestBody Question question) {
		return adminService.save(question);
	}


	@PutMapping("/question/{sno}")
	public ResponseEntity<Question> updateQuestion(@PathVariable(value = "Sno") int Sno,
			@RequestBody Question question)
	{
        question.setSno(Sno);
        return ResponseEntity.ok().body(this.adminService.updateQuestion(question));
    }
	
	@DeleteMapping("/question/{sno}")
	public Optional<Question> deleteQuestion(@PathVariable int sno) 
	{
		return adminService.deleteQuestion(sno);
	}
	



}
