package com.luv2code.springboot.cruddemo.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.luv2code.springboot.cruddemo.entity.UsersInfo;
@Repository
public interface UsersRepository extends JpaRepository<UsersInfo, Integer> {


	
	@Query("from UsersInfo where email = ?1")
	UsersInfo findByemail(String email); 
}
