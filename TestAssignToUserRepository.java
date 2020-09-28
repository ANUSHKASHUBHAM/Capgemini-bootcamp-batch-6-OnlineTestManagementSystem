package com.capgemini.onlinetestmangementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmangementsystem.entity.TestAssignToUser;


@Repository
public interface TestAssignToUserRepository extends JpaRepository<TestAssignToUser, Integer>{

}
