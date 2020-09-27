
package com.capgemini.onlinetestmanagementsystem.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class TestEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="test_id")
	Long testId;
	
	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
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

	public QuestionEntity getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(QuestionEntity testQuestion) {
		this.testQuestion = testQuestion;
	}

	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}

	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
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

	@Column(name="test_title")
	String testTitle;
	
	@Column(name="test_duration")
	LocalTime testDuration;
	
	@Column(name="test_Question")
	QuestionEntity testQuestion;

	@Column(name="test_totalmarks")
	BigDecimal testTotalMarks;
	
	@Column(name="start_time")
	LocalDateTime startTime;

	@Column(name="end_time")
	LocalDateTime endTime;
	

}
