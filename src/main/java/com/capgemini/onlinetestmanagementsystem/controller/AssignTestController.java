package com.capgemini.onlinetestmanagementsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagementsystem.entity.AssignTestEntity;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.service.IAssignTest;

@RestController
@RequestMapping("/test")
public class AssignTestController {

	@Autowired 
	IAssignTest assignTestService;
	
	@PostMapping("/assign")
	public String saveAssignTest(@RequestBody AssignTestEntity asstestDetails )
	{
		
		String result = assignTestService.saveAssignTest(asstestDetails);
		
		return result;
		
	}
	
	@GetMapping("/schedule/{id}")
	public List<TestEntity> getSchedule(@PathVariable("id") String testTitle)
	{
		
		List<TestEntity> testList = assignTestService.getTestList(testTitle);
		new ResponseEntity<List<TestEntity>>(testList, new HttpHeaders(),HttpStatus.OK);
		return testList;

		
	}
}
