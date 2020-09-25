package com.capgemini.onlinetestmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Long UserId;
	@NotEmpty(message = "Name is required")
	@Size(min=5,max=20,message="User name should be minimum 5 and maximum 20 characters long")
	private String UserName;
	@OneToOne(targetEntity=TestManagement.class)
	private TestManagement userTest;
	private boolean isAdmin;
	@NotEmpty(message = "Password is required")
	@Size(min=8,message="Password should be minimum 8 characters long")
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
	public TestManagement getUserTest() {
		return userTest;
	}
	public void setUserTest(TestManagement userTest) {
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
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", userTest=" + userTest + ", isAdmin=" + isAdmin
				+ ", userPassword=" + userPassword + "]";
	}
	

	

}
