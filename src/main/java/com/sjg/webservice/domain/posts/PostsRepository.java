package com.sjg.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sjg.webservice.dto.posts.PostsMainResponseDto;

public interface PostsRepository extends JpaRepository<Posts, Long>{
	@Query("SELECT p " 
		+ "FROM Posts p " 
		+ "ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();
	
	@Query("SELECT new com.sjg.webservice.domain.posts.Posts(node, COUNT(parent.content) AS depth) " + 
			"FROM Posts AS node INNER JOIN Posts AS parent ON node.lft BETWEEN parent.lft AND parent.rgt " + 
			"GROUP BY node.id " + 
			"ORDER BY node.lft")
	Stream<Posts> findAllPostsAsTree();
	
	@Query("SELECT p " 
			+ "FROM Posts p WHERE id = :id")
	PostsMainResponseDto findPostById(@Param("id") Long id);
	
	@Modifying
	@Query("UPDATE Posts SET rgt = rgt + 2 WHERE rgt > :upperLeft and (root_id = :rootId or id = :rootId)")
	void updateRight(@Param("rootId") Long rootId, @Param("upperLeft") Long upperLeft);

	@Modifying
	@Query("UPDATE Posts SET lft = lft + 2 WHERE lft > :upperLeft and (root_id = :rootId or id = :rootId)")
	void updateLeft(@Param("rootId") Long rootId, @Param("upperLeft") Long upperLeft);
}