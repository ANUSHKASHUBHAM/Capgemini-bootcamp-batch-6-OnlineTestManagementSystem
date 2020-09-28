package com.capgemini.onlinetestmangementsystem.controller;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.onlinetestmangementsystem.dao.TestRepository;
import com.capgemini.onlinetestmangementsystem.dao.UserRepository;
import com.capgemini.onlinetestmangementsystem.entity.Test;
import com.capgemini.onlinetestmangementsystem.entity.TestAssignToUser;
import com.capgemini.onlinetestmangementsystem.entity.User;
import com.capgemini.onlinetestmangementsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinetestmangementsystem.service.TestAssignToUserService;
import com.capgemini.onlinetestmangementsystem.service.TestAssignToUserServiceImpl;

@RestController
@RequestMapping("/testassign")
public class TestAssignToUserController {
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TestAssignToUserService service;
	List<TestAssignToUser> testList = new ArrayList<TestAssignToUser>();
	
	/*This method is used to save the record in the database.*/
	
	@GetMapping("/assign/{uid}/{tid}")
	public String assignTest(@PathVariable("uid") int userId, @PathVariable("tid") int testId) throws ResourceNotFoundException
	{
		return service.saveAssignTest(userId,testId);
	}


	/* This method is used to get the records from the database. */
	
	@GetMapping("/assigned_test")
	public List<TestAssignToUser> getAllproduct() throws ResourceNotFoundException {
		testList = service.getAllProduct();
		new ResponseEntity<List<TestAssignToUser>>(testList , new HttpHeaders(),HttpStatus.OK);
		return testList;
		
	}
	
	/*This method is used to save the test details*/
	
	@PostMapping("/testtable")
	public void saveTest() 
	{
		LocalTime st=LocalTime.of(18, 30);
		LocalTime et =LocalTime.of(19, 00);
		Test test = new  Test();
		test.setTestId(1003);
		test.setTopic("Economics");
		test.setStartTime(st);
		test.setEndTime(et);
		test.setDuration(30);
		test.setMarks(100);
		test.setMinMarks(30);
		testRepository.save(test);
 
	}
	
	/*This method is used to save the user details*/
	
	@PostMapping("/usertable")
	public void saveUser()
	{ 
		User user = new  User();
		user.setUserId(19609);;
		user.setIsAdmin("NO");
		user.setUserPassword("MNO");
		user.setUserName("MNO121");
		user.setUserTest(1003);
		userRepository.save(user);

	}
	
	
}

