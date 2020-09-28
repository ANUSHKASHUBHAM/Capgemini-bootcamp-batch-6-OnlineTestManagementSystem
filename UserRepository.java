package com.capgemini.onlinetestmangementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmangementsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

