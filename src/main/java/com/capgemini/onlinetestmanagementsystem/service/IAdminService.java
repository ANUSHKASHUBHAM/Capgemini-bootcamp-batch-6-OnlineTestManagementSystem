package com.capgemini.onlinetestmanagementsystem.service;

import com.capgemini.onlinetestmanagementsystem.entity.Admin;

public interface IAdminService {
	Admin loginAdmin(String adminName,String adminPassword);
	Admin getAdmin(String adminId);
	boolean deleteAdmin(String adminId);

}
