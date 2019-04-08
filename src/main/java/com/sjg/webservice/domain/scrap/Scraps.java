package com.sjg.webservice.domain.scrap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sjg.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Scraps extends BaseTimeEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private Long postId;

	private String scrapAuthor;

		
	@Builder
	public Scraps(Long postId, String scrapAuthor) {
		this.postId = postId;
		this.scrapAuthor = scrapAuthor;
	}
}