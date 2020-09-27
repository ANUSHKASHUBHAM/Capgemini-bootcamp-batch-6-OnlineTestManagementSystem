package com.capgemini.onlinetestmanagementsystem.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;
import com.capgemini.onlinetestmanagementsystem.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	@Modifying
	@Query(value="update User u set u.user_test= ?1 where u.user_id=?2")
	void updateUser(TestEntity testDetails, Long userId);

}
