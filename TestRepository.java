package com.capgemini.onlinetestmangementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmangementsystem.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{

}

