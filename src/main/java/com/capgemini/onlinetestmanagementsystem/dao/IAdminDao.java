package com.capgemini.onlinetestmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.onlinetestmanagementsystem.entity.Admin;

public interface IAdminDao extends JpaRepository<Admin, String>{
	
	public Admin findAdminByAdminName(String adminName);

}

