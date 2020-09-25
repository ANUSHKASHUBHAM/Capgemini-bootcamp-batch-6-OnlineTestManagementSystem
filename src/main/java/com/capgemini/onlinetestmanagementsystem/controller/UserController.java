package com.capgemini.onlinetestmanagementsystem.controller;

import java.util.List;

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

import com.capgemini.onlinetestmanagementsystem.dto.UserDetails;
import com.capgemini.onlinetestmanagementsystem.dto.UserDto;
import com.capgemini.onlinetestmanagementsystem.entity.User;
import com.capgemini.onlinetestmanagementsystem.service.IUserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger Log= LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUserService service;
	@PostMapping("/add")
	public ResponseEntity<User>addUser(@RequestBody @Valid UserDto userDto )
	{
		User user=convertFromDto(userDto);
		User myUser=service.addUser(user);
		  Log.info("User Added ");
		  System.out.println(myUser);
		ResponseEntity<User>response=new ResponseEntity<User>(myUser, HttpStatus.OK);
		return response;
	}
	public User convertFromDto(UserDto dto) {
		User user=new User();
		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setUserPassword(dto.getUserPassword());
		user.setAdmin(dto.isAdmin());
		return user;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto userDto) {
		User user = convertFromDto(userDto);
		user.setUserId(userId);
		user = service.updateUser(userId, user);
		  Log.info("User updated ");
		ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.OK);
		return response;
	}
	
	 @GetMapping("/remove/{id}")
		public ResponseEntity<Boolean> deleteTest(@PathVariable("id") Long userId) {
			User result = service.deleteUser(userId);
			  Log.info("User Removed ");
			ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
			return response;
		}

	 
	 @GetMapping("/get/{id}")
	 public ResponseEntity<UserDetails>getTest(@PathVariable("id")Long userId){
			User user = service.findById(userId);
			UserDetails details=convertToUserDetails(user);
			ResponseEntity<UserDetails>response=new ResponseEntity<>(details, HttpStatus.OK);
			return response;
			
		  }
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	 	public List<User>fetchAll(){
		 List<User> user=service.fetchAll();
		 Log.info("Users fetched");
		 System.out.println(user);
		 return user;
	 }
	 	
	 UserDetails convertToUserDetails(User user)
	 {
		 	UserDetails details=new UserDetails();
		 	details.setUserId(user.getUserId());
		 	details.setUserName(user.getUserName());
			details.setUserPassword(user.getUserPassword());
			details.setUserTest(user.getUserTest());
			details.setAdmin(user.isAdmin());
			
		 	return details;
	 }
	 
	 
}
