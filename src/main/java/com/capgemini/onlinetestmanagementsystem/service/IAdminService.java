package com.capgemini.onlinetestmanagementsystem.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetestmanagementsystem.entity.Admin;
import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;

public interface IAdminService {
	Admin loginAdmin(String adminName,String adminPassword);
	Admin getAdmin(String adminId);
	boolean deleteAdmin(String adminId);

	public TestEntity addTest(TestEntity test);
	public TestEntity updateTest(BigInteger testId, TestEntity test);
	public TestEntity deleteTest(BigInteger testId);
	public List<TestEntity> fetchAll();
	public TestEntity findById(BigInteger testId);
	public Question createQuestion(Question question);
    public List<Question> getAllQuestion();
    public Optional<Question> deleteQuestion(int Sno);
	public Question save(Question question);
<<<<<<< HEAD
	public Optional<Question> getQuestionBySno(int sno);
	public Optional<Question> deleteQuestion(int sno) throws ResourceNotFoundException;
	
	
	TestEntity addTest(TestEntity test);

	TestEntity updateTest(BigInteger testId, TestEntity test);

	TestEntity deleteTest(BigInteger testId);

	List<TestEntity> fetchAll();

	TestEntity findById(BigInteger testId);

=======
	public Optional<Question> getQuestionBySno(int Sno);
	
>>>>>>> branch 'master' of https://github.com/ANUSHKASHUBHAM/Capgemini-bootcamp-batch-6-OnlineTestManagementSystem.git
	
	
	
	
}
