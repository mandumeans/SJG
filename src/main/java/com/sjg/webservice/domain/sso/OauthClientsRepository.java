package com.sjg.webservice.domain.sso;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OauthClientsRepository extends JpaRepository<OauthClients, Long>{
	@Query("SELECT p " 
			+ "FROM OAuthClients p " 
			+ "ORDER BY p.id DESC")
	Stream<OauthClients> findAllDesc();
}