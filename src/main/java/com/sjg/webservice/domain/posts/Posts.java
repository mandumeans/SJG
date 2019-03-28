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
	private Long rootId;
	
    private Long lft;
    private Long rgt;
    
    @Transient
    private Long depth;
		
	@Builder
	public Posts(String title, String content, String author, Long rootId, Long lft, Long rgt) {
		this.title = title;
		this.content = content;
		this.author = author;
		this.rootId = rootId;
		this.lft = lft;
		this.rgt = rgt;
	}
	
	public Posts(Posts entity, Long depth) {
		this(entity.getTitle(), entity.getContent(), entity.getAuthor(), entity.getRootId(), entity.getLft(), entity.getRgt());
		this.id = entity.getId();
		this.depth = depth;
	}
}