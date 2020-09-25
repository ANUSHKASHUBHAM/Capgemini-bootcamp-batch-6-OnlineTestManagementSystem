package com.capgemini.onlinetestmanagementsystem;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.capgemini.onlinetestmanagementsystem.dao.IQuestionDao;
import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.service.QuestionServiceImpl;

public class MockitoQuestion {
	
	@Mock
	private IQuestionDao dao;
	@InjectMocks
	private QuestionServiceImpl service;
	
	
	
	
	@Test
	public void testgetQuestion()
	{
		Question question = new Question();
		question.setSno(1);
		question.setQuestiondomain("What does “Timeboxed” means in Agile terms?");
		question.setOption1("Fast");
		question.setOption2("Flexible");
		question.setOption3("Frequent");
		question.setOption4("Fixed");
		question.setCorrectoption("D");
		question.setQuestionmarks(2);
		service.getQuestion();
		Mockito.verify(dao, Mockito.times(1)).save(question);
	}

}
