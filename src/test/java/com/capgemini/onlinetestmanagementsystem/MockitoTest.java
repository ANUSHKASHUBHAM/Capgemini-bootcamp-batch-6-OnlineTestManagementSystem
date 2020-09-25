package com.capgemini.onlinetestmanagementsystem;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.onlinetestmanagementsystem.dao.ITestDao;
import com.capgemini.onlinetestmanagementsystem.entity.TestManagement;
import com.capgemini.onlinetestmanagementsystem.service.TestServiceImpl;

@SpringBootTest
class OnlinetestmanagementsystemApplicationTests
{
	
@Mock
private ITestDao dao;
@InjectMocks
private TestServiceImpl service;
	

LocalTime time= LocalTime.of(2, 0);
LocalDateTime startDateTime = LocalDateTime.of(2020, 2, 13, 12, 00);
LocalDateTime endDateTime = LocalDateTime.of(2020, 2, 13, 14, 00);
	@Test
    public void testaddTest() 
	{
	    
		TestManagement testManagement= new TestManagement();
		testManagement.setTestId(10);
		testManagement.setTestTitle("Java");
		testManagement.setTestMarksScored(70);
		testManagement.setTestTotalMarks(100);
		testManagement.setTestDuration(time);
		testManagement.setStartTime(startDateTime);
		testManagement.setEndTime(endDateTime);
		
		service.addTest(testManagement);
		Mockito.verify(dao, Mockito.times(1)).save(testManagement);
		
	    
	  
	}

}
