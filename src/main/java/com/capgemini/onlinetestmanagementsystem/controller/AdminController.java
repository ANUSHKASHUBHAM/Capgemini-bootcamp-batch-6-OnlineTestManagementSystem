package com.capgemini.onlinetestmanagementsystem.controller;

import java.util.List;
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

import com.capgemini.onlinetestmanagementsystem.entity.Admin;
import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;
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
	@GetMapping("/question")
	public List<Question> getAllQuestions() {
		return adminService.getAllQuestion();
	}

	@GetMapping("/question/{sno}")
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "sno") int sno)
			throws ResourceNotFoundException {
		Question question = adminService.getQuestionBySno(sno)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found for this sno :: " + sno));
		return ResponseEntity.ok().body(question);
	}

	@PostMapping(path="/question",consumes="application/json",produces="application/json")
	public Question createQuestion(@RequestBody Question question) {
		return adminService.save(question);
	}

	@PutMapping("/question/{sno}")
	public ResponseEntity<Question> updateQuestion(@PathVariable(value = "sno") int sno,
			@RequestBody Question questionDetails) throws ResourceNotFoundException {
		Question question = adminService.getQuestionBySno(sno)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found for this sno :: " + sno));

		question.setQuestionvalue(questionDetails.getQuestionvalue());
		question.setQuestionmarks(questionDetails.getQuestionmarks());
		question.setQuestiondomain(questionDetails.getQuestiondomain());
		question.setCorrectoption(questionDetails.getCorrectoption());
		question.setOption1(questionDetails.getOption1());
		question.setOption2(questionDetails.getOption2());
		question.setOption3(questionDetails.getOption3());
		question.setOption4(questionDetails.getOption4());
		final Question updatedQuestion = adminService.save(question);
		return ResponseEntity.ok(updatedQuestion);
	}

	@DeleteMapping("/question/{sno}")
	public Optional<Question> deleteQuestion(@PathVariable(value = "sno") int sno) throws ResourceNotFoundException
	{
		return adminService.deleteQuestion(sno);
	}
	


}
