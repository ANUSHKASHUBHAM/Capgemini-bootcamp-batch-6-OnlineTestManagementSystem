package com.capgemini.onlinetestmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagementsystem.entity.Question;

@Repository
public interface IQuestionDao extends JpaRepository<Question, Integer>{

}

