package com.capgemini.onlinetestmanagementsystem.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.capgemini.onlinetestmanagementsystem.entity.TestManagement;

public interface ITestDao  extends JpaRepository<TestManagement,Integer> {

}
