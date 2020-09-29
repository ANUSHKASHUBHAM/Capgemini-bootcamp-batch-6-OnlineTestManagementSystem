package com.capgemini.onlinetestmanagementsystem.service;

import java.util.List;

import com.capgemini.onlinetestmanagementsystem.entity.User;





public interface IUserService {
	User addUser(User user);

	User findById(Long userId);

	User updateUser(Long userId, User user);
	
	User deleteUser(Long userId);
	
	List<User> fetchAll();

}
