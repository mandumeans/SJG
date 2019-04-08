package com.sjg.webservice.domain.scrap;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScrapsRepository extends JpaRepository<Scraps, Long>{
	@Query("SELECT p " 
			+ "FROM Scraps p WHERE scrapAuthor = :author " 
			+ "ORDER BY p.id DESC")
	Stream<Scraps> findAllDesc(@Param("author") String author);
}