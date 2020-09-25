package com.capgemini.onlinetestmanagement.dto;

public class UserDto {
	
	@Override
	public String toString() {
		return "UserDto [UserId=" + userId + ", UserName=" + userName + ", isAdmin=" + isAdmin + ", userPassword="
				+ userPassword + "]";
	}
	private Long userId;
	private String userName;
	private boolean isAdmin;
	private String userPassword;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
