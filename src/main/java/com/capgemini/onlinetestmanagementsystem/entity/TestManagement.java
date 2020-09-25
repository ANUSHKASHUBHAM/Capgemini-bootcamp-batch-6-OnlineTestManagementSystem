package com.capgemini.onlinetestmanagementsystem.entity;


import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Test")
public class TestManagement {
	

	
	@Id
	@GeneratedValue
	private Integer testId;
	private String testTitle;
	private LocalTime testDuration;
	private double testTotalMarks;
	private double testMarksScored;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public TestManagement() {
		super();
		
	}

	
	
	public TestManagement(Integer testId, String testTitle, LocalTime testDuration, double testTotalMarks,
			double testMarksScored, LocalDateTime startTime, LocalDateTime endTime)
	{
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public LocalTime getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}

	public double getTestTotalMarks() {
		return testTotalMarks;
	}

	public void setTestTotalMarks(double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public double getTestMarksScored() {
		return testMarksScored;
	}

	public void setTestMarksScored(double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	

}
