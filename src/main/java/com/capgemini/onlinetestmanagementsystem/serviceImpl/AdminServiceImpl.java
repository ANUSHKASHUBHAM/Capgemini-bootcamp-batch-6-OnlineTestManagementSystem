package com.capgemini.onlinetestmanagementsystem.serviceImpl;



import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinetestmanagementsystem.dao.IAdminDao;
import com.capgemini.onlinetestmanagementsystem.dao.IQuestionDao;
import com.capgemini.onlinetestmanagementsystem.dao.ITestDao;
import com.capgemini.onlinetestmanagementsystem.entity.Admin;
import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.exception.AdminNotFoundException;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinetestmanagementsystem.exception.TestNotFoundException;
import com.capgemini.onlinetestmanagementsystem.service.IAdminService;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	
	
	@Autowired
	private IAdminDao adminRepository;

	/*
	  * This is a GetMethod(Http) is used to check the authorization of Name and Password from Database.
	  * Method 	  : loginAdmin
	  * Type 	  : Admin 
	  * parameters: the adminName and adminPassword is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@Override
	public Admin loginAdmin(String adminName, String adminPassword){
		Admin admin = adminRepository.findAdminByAdminName(adminName);
		if (!(admin.getAdminPassword().equals(adminPassword)
				&& admin.getAdminName().equals(adminName)))
		{
		
			throw new AdminNotFoundException(
					"Admin with AdminName [" + adminName + "] and password [" + adminPassword + "] not found");
		}
		else
		{
			return admin;
		}
		
	}


	
	/*
	  * This is a GetMethod(Http) used to get the Admin Details using Admin Id from Database.
	  * Method 	  : getAdmin
	  * Type 	  : Admin
	  * parameters: the adminId is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@Override
	public Admin getAdmin(String adminId) {
		if(!adminRepository.existsById(adminId))
			throw new AdminNotFoundException("User with id "+adminId+" Not Found");
		return adminRepository.getOne(adminId);
	}
	
	/*
	  * This is a DeleteMethod(Http) used to delete the Admin Details using Admin Id from Database.
	  * Method 	  : deleteAdmin
	  * Type 	  : Boolean
	  * parameters: the adminId is of String type
	  * Returns   : Boolean
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@Override
	public boolean deleteAdmin(String adminId) {
		if (!adminRepository.existsById(adminId))
			throw new AdminNotFoundException("Customer with id " + adminId + " Not Found");
		adminRepository.deleteById(adminId);
		return true;
	}
	
		 @Autowired
			private ITestDao testDao;
			
			
			/*
			 ***************************************************
			 *This method is used to add new test
			 *************************************************** 
			 */
			
			@Override
			public TestEntity addTest(TestEntity test) 
			{	
					test = testDao.save(test);
					return test;
			}
			
			/*
			 ***************************************************
			 *This method is used to update existing test
			 *************************************************** 
			 */
			

			@Override
			public TestEntity updateTest(BigInteger testId, TestEntity test) 
			{
				boolean exists = testDao.existsById(testId);
				if (exists)
				{
					test = testDao.save(test);
					return test;
				}
				throw new TestNotFoundException("Test not found for id="+testId);
			}
			
			/*
			 ***************************************************
			 *This method is used to delete existing test
			 *************************************************** 
			 */

			@Override
			public TestEntity deleteTest(BigInteger testId) 
			{
				TestEntity test = findById(testId);
				testDao.delete(test);
				return test;
			}
			
			
			/*
			 ***************************************************
			 *This method is used to find test byId
			 *************************************************** 
			 */



			@Override
			public TestEntity findById(BigInteger testId)
			{
				 Optional<TestEntity>optional=testDao.findById(testId);
			     if(optional.isPresent())
			     {
			         TestEntity test=optional.get();
			         return test;
			     }
			     throw new TestNotFoundException("Test not found for id="+testId);
			    }
			
			/*
			 ***************************************************
			 *This method is used to fetch All test
			 *************************************************** 
			 */
			@Override
			public List<TestEntity> fetchAll() 
			{
				List<TestEntity> tests = testDao.findAll();
				return tests;
			}
			

			@Autowired
			IQuestionDao questionDao;
			@Override
			public Question createQuestion(Question question)
			{
				return questionDao.save(question);
			}

			@Override
			public List<Question> getAllQuestion() 
			{
				return questionDao.findAll();
			}

			@Override
			public Optional<Question> deleteQuestion(int Sno) {
				Optional<Question> question =questionDao.findById(Sno);
				questionDao.deleteById(Sno);
					return question;
				}
			@Override
			public Question getQuestionBySno(int Sno)
			{
			 Optional < Question > questionDb = this.questionDao.findById(Sno);

	         return questionDb.get();
	        }
			@Override
			public Question save(Question question)
			{
				return questionDao.save(question);
			}


			@Override
			public Question updateQuestion(Question question)
			{
				 Optional < Question > questionDb = this.questionDao.findById(question.getSno());
	        
	            Question questionUpdate = questionDb.get();
	            questionUpdate.setQuestionvalue(question.getQuestionvalue());
	            questionUpdate.setQuestiondomain(question.getQuestiondomain());
	            questionUpdate.setQuestiondomain(question.getQuestiondomain());
	            questionUpdate.setCorrectoption(question.getCorrectoption());
	            questionUpdate.setOption1(question.getOption1());
	            questionUpdate.setOption2(question.getOption2());
	            questionUpdate.setOption3(question.getOption3());
	            questionUpdate.setOption4(question.getOption4());
	            return questionUpdate;
			}
			
			    

	
	

}
