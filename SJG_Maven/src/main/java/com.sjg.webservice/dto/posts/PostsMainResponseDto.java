package com.sjg.webservice.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sjg.webservice.domain.posts.Posts;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;
    private Long lft;
    private Long rgt;
    private Long depth;
    
    @Setter
	private Long rootId;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
        lft = entity.getLft();
        rgt = entity.getRgt();
        rootId = entity.getRootId();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
        depth = entity.getDepth();
    }
    
    private String toStringDateTime(LocalDateTime localDateTime) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return Optional.ofNullable(localDateTime).map(formatter::format).orElse("");
    }
}