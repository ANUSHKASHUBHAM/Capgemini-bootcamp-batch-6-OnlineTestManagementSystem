package com.capgemini.onlinetestmanagementsystem.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;





public interface ITestDao extends JpaRepository<TestEntity,BigInteger>{

}
