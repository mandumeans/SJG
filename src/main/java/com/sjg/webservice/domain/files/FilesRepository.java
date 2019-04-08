package com.sjg.webservice.domain.files;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilesRepository extends JpaRepository<Files, Long>{
	@Query("SELECT p " 
			+ "FROM Files p " 
			+ "ORDER BY p.id DESC")
	Stream<Files> findAllDesc();
}