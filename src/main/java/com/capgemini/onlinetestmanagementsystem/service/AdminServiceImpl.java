package com.capgemini.onlinetestmanagementsystem.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagementsystem.dao.IAdminDao;
import com.capgemini.onlinetestmanagementsystem.entity.Admin;
import com.capgemini.onlinetestmanagementsystem.exception.AdminNotFoundException;


@Service
public class AdminServiceImpl implements IAdminService{
	
	
	@Autowired
	private IAdminDao adminRepository;

	/*
	  * This is a GetMethod(Http) is used to check the authorization of Name and Password from Database.
	  * Method 	  : loginAdmin
	  * Type 	  : Admin 
	  * parameters: the adminName and adminPassword is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@Override
	public Admin loginAdmin(String adminName, String adminPassword){
		Admin admin = adminRepository.findAdminByAdminName(adminName);
		if (!(admin.getAdminPassword().equals(adminPassword)
				&& admin.getAdminName().equals(adminName)))
		{
		
			throw new AdminNotFoundException(
					"Admin with AdminName [" + adminName + "] and password [" + adminPassword + "] not found");
		}
		else
		{
			return admin;
		}
		
	}


	
	/*
	  * This is a GetMethod(Http) used to get the Admin Details using Admin Id from Database.
	  * Method 	  : getAdmin
	  * Type 	  : Admin
	  * parameters: the adminId is of String type
	  * Returns   : the object of Admin
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@Override
	public Admin getAdmin(String adminId) {
		if(!adminRepository.existsById(adminId))
			throw new AdminNotFoundException("User with id "+adminId+" Not Found");
		return adminRepository.getOne(adminId);
	}
	
	/*
	  * This is a DeleteMethod(Http) used to delete the Admin Details using Admin Id from Database.
	  * Method 	  : deleteAdmin
	  * Type 	  : Boolean
	  * parameters: the adminId is of String type
	  * Returns   : Boolean
	  * Author 	  : Alok Dixit
	  * Date 	  : 25/09/2020
	  * Version   : 1.0
	  */
	@Override
	public boolean deleteAdmin(String adminId) {
		if (!adminRepository.existsById(adminId))
			throw new AdminNotFoundException("Customer with id " + adminId + " Not Found");
		adminRepository.deleteById(adminId);
		return true;
	}

}
