package com.sjg.webservice.dto.scraps;

import com.sjg.webservice.domain.scrap.Scraps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScrapsSaveRequestDto {
	private Long postId;
	private String scrapAuthor;
	
	public Scraps toEntity() {
		return Scraps.builder()
				.postId(postId)
				.scrapAuthor(scrapAuthor)
				.build();
	}
}