package com.capgemini.onlinetestmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Adminlogin")
public class Admin {
	private int id;
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}
	
	

}
