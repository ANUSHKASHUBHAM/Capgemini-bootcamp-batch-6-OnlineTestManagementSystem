
	package com.capgemini.onlinetestmanagementsystem.entity;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	@Entity
	@Table(name="AssignTest")
		
	public class TestAssignToUser {

		@Id
		@Column(name="UserId")
		private int userId;
		
		@Column(name="TestId")
		private int testId;

		public int getTestId() {
			return testId;
		}

		public void setTestId(int testId) {
			this.testId = testId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		
		public TestAssignToUser() {}

		public TestAssignToUser(int testId, int userId) {

			this.testId = testId;
			this.userId = userId;
		}	
			

	}





