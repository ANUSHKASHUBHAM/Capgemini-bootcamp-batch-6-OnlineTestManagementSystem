package com.capgemini.onlinetestmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;

public interface IQuestionService {
	
	public List<Question> getQuestion();
	public Question save(Question question);
	public Optional<Question> getQuestionBySno(int sno);
	public Optional<Question> deleteQuestion(int sno) throws ResourceNotFoundException;

}

