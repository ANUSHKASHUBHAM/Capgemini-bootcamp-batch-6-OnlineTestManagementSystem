package com.capgemini.onlinetestmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinetestmanagementsystem.dao.IQuestionDao;
import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;

@Service
@Transactional
public class QuestionServiceImpl  implements IQuestionService {
	
@Autowired
IQuestionDao questionDao;

	@Override
	public List<Question> getQuestion() {
		List<Question> question = new ArrayList<Question>();  
		questionDao.findAll().forEach(question1 -> question.add(question1));  
		return question;  
		
	}

	@Override
	public Question save(Question question) {
		return questionDao.save(question); 
	}

	@Override
	public Optional<Question> getQuestionBySno(int sno) {
		return questionDao.findById(sno);
		
	}

	@Override
	public Optional<Question> deleteQuestion(int sno) throws ResourceNotFoundException{
	Optional<Question> question =questionDao.findById(sno);
	if(question!=null)
	{
		questionDao.deleteById(sno);
		return question;
		
	}else
	{
		throw new ResourceNotFoundException("No question exists of thid Sno");

}
}
}