package com.capgemini.onlinetestmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignedtest")
public class AssignTestEntity {
	@Id
	@Column (name="user_id")
	Long userId;
	@Column(name="test_id")
	Long testId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	

}
