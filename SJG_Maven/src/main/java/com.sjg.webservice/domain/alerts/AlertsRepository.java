package com.sjg.webservice.domain.alerts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlertsRepository extends JpaRepository<Alerts, Long>{
	@Query("SELECT p " 
			+ "FROM Alerts p WHERE alertAuthor = :author " 
			+ "ORDER BY p.id DESC")
	Stream<Alerts> findAllDesc(@Param("author") String author);
}