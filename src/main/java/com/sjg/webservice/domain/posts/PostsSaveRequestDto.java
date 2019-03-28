package com.sjg.webservice.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	private String title;
	private String content;
	private String author;
	private Long rootId;
	private Long lft;
	private Long rgt;
	private Long upperId;
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.rootId(rootId)
				.lft(lft)
				.rgt(rgt)
				.build();
	}
}