package com.sjg.webservice.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sjg.webservice.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;
    private Long upperId;
    
    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        content = entity.getContent();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
        upperId = entity.getUpperId();
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return Optional.ofNullable(localDateTime).map(formatter::format).orElse("");
    }
    
}