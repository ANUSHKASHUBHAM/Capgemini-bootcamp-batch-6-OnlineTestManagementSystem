package com.capgemini.onlinetestmanagementsystem.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagementsystem.entity.TestEntity;

@Repository
@Transactional
public interface TestRepository extends CrudRepository<TestEntity, Long>{

	@Query(value="select * from test where test_title=?1",nativeQuery=true)
	List<TestEntity>findByKeyword(String testTtitle);
	
	
}
