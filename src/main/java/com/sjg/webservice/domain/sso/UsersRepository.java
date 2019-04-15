package com.sjg.webservice.domain.sso;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long>{
	@Query("SELECT p " 
			+ "FROM Users p " 
			+ "ORDER BY p.id DESC")
	Stream<Users> findAllDesc();
}