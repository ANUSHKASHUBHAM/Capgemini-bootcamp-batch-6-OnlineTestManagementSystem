package com.capgemini.onlinetestmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Adminlogin")
public class Admin {
	@Id
	@GeneratedValue
	private String adminId;
	private String adminName;
	private String adminPassword;
	@OneToMany(targetEntity=TestEntity.class)
	private TestEntity adminTest;
	
	@OneToMany(targetEntity = Question.class)
	private Question question;
	
	
	public Admin() {
		super();
	}


	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	public TestEntity getAdminTest() {
		return adminTest;
	}

	public void setUserTest(TestEntity adminTest) {
		this.adminTest = adminTest;
	}
	public Admin(String adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	


}
