package com.sjg.webservice.domain.posts;

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
public class Alerts extends BaseTimeEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private Long postId;

	private String alertAuthor;
	
	@Column(length=1, nullable=false)
	private String isRead;
		
	@Builder
	public Alerts(Long postId, String alertAuthor, String isRead) {
		this.postId = postId;
		this.alertAuthor = alertAuthor;
		this.isRead = isRead;
	}
}