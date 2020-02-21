package com.sjg.webservice.dto.scraps;

import com.sjg.webservice.domain.scrap.Scraps;

import lombok.Getter;

@Getter
public class ScrapsMainResponseDto {
    private Long id;
    private String isRead;
    private String scrapAuthor;
	private Long postId;

    public ScrapsMainResponseDto(Scraps entity) {
        id = entity.getId();
        postId = entity.getPostId();
        scrapAuthor = entity.getScrapAuthor();
    }
}