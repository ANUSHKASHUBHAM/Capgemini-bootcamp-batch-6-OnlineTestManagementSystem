package com.capgemini.onlinetestmanagementsystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.onlinetestmanagementsystem.entity.User;



public interface IUserDao extends JpaRepository<User, Long> {

}
