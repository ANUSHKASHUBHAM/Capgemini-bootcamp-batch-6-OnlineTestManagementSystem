package com.capgemini.onlinetestmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagementsystem.entity.Question;
import com.capgemini.onlinetestmanagementsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinetestmanagementsystem.service.IQuestionService;

public class QuestionController {
	
	
	@RestController
	@RequestMapping("/subject")
	public class QuestionAnswerAdminController {
		@Autowired
		private IQuestionService questionService;

		@GetMapping("/question")
		public List<Question> getAllQuestions() {
			return questionService.getQuestion();
		}

		@GetMapping("/question/{sno}")
		public ResponseEntity<Question> getQuestionById(@PathVariable(value = "sno") int sno)
				throws ResourceNotFoundException {
			Question question = questionService.getQuestionBySno(sno)
					.orElseThrow(() -> new ResourceNotFoundException("Question not found for this sno :: " + sno));
			return ResponseEntity.ok().body(question);
		}

		@PostMapping(path="/question",consumes="application/json",produces="application/json")
		public Question createQuestion(@RequestBody Question question) {
			return questionService.save(question);
		}

		@PutMapping("/question/{sno}")
		public ResponseEntity<Question> updateQuestion(@PathVariable(value = "sno") int sno,
				@RequestBody Question questionDetails) throws ResourceNotFoundException {
			Question question = questionService.getQuestionBySno(sno)
					.orElseThrow(() -> new ResourceNotFoundException("Question not found for this sno :: " + sno));

			question.setQuestionvalue(questionDetails.getQuestionvalue());
			question.setQuestionmarks(questionDetails.getQuestionmarks());
			question.setQuestiondomain(questionDetails.getQuestiondomain());
			question.setCorrectoption(questionDetails.getCorrectoption());
			question.setOption1(questionDetails.getOption1());
			question.setOption2(questionDetails.getOption2());
			question.setOption3(questionDetails.getOption3());
			question.setOption4(questionDetails.getOption4());
			final Question updatedQuestion = questionService.save(question);
			return ResponseEntity.ok(updatedQuestion);
		}

		@DeleteMapping("/question/{sno}")
		public Optional<Question> deleteQuestion(@PathVariable(value = "sno") int sno) throws ResourceNotFoundException
		{
			return questionService.deleteQuestion(sno);
		}
		
	}
}


