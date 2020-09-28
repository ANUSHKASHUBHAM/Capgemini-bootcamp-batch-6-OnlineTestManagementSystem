package com.capgemini.onlinetestmangementsystem.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test {
	
	@Id
	@Column(name="testId")
	int testId;
	
	@Column(name="topic")
	String topic;
	
	@Column(name="marks")
	int marks;
	@Column(name="minMarks")
	int minMarks;
	@Column(name="duration")
	double duration;
	@Column(name="startTime")
	LocalTime startTime;
	@Column(name="endTime")
	LocalTime endTime;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getMinMarks() {
		return minMarks;
	}
	public void setMinMarks(int minMarks) {
		this.minMarks = minMarks;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
}
