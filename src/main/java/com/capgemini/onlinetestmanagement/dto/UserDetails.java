package com.capgemini.onlinetestmanagement.dto;

import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;

public class UserDetails {
	
	private Long UserId;
	private String UserName;
	private TestEntity userTest;
	private boolean isAdmin;
	private String userPassword;
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public TestEntity getUserTest() {
		return userTest;
	}
	public void setUserTest(TestEntity userTest) {
		this.userTest = userTest;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDetails [UserId=" + UserId + ", UserName=" + UserName + ", userTest=" + userTest + ", isAdmin="
				+ isAdmin + ", userPassword=" + userPassword + "]";
	}


}
