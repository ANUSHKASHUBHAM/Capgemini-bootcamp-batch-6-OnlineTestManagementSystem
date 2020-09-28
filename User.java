	package com.capgemini.onlinetestmangementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
public class User {
	
	@Id
	@Column(name="userId")
	int userId;
	
	@Column(name="userName")
	String userName;
	@Column(name="userTest")
	int userTest;
	@Column(name="isAdmin")
	String isAdmin;
	@Column(name="userPassword")
	String userPassword;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserTest() {
		return userTest;
	}
	public void setUserTest(int userTest) {
		this.userTest = userTest;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
