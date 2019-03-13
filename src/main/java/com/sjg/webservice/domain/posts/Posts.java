package com.sjg.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.sjg.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=500, nullable=false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;

	@Column(nullable = true)
	private Long upperId;
	
	@Transient
	private Long lev;
	
	public Long getLev() {
		if(upperId == null) {
			return id;
		} else {
			return upperId;
		}
	}
	
	@Builder
	public Posts(String title, String content, String author, Long upperId) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.upperId = upperId;
	}
}