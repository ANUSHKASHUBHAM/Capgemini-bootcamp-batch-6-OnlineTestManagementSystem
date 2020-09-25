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
	@Override
	public String toString() {
		return "User [UserId=" + userId + ", UserName=" + userName + ", userTest=" + userTest + ", isAdmin=" + isAdmin
				+ ", userPassword=" + userPassword + "]";
	}

	@Id
	@GeneratedValue
	private Long userId;
	@NotEmpty(message = "Name is required")
	@Size(min=5,max=20,message="User name should be minimum 5 and maximum 20 characters long")
	private String userName;
	@OneToOne(targetEntity=TestEntity.class)
	private TestEntity userTest;
	private boolean isAdmin;
	@NotEmpty(message = "Password is required")
	@Size(min=8,message="Password should be minimum 8 characters long")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
