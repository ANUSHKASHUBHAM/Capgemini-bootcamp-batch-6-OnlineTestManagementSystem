package com.capgemini.onlinetestmanagementsystem.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	Long userId;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="user_password")
	String userPassword;
	
	@Column(name="is_admin")
	int isAdmin;
	
	@Column(name="user_test")
	TestEntity userTest;

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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public TestEntity getUserTest() {
		return userTest;
	}

	public void setUserTest(TestEntity userTest) {
		this.userTest = userTest;
	} 
}
