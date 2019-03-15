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
    private Long upperId;
    
    @Setter
	private Long rootId;
    
    @Setter
	private Long depth;
	
    
    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        content = entity.getContent();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
        upperId = entity.getUpperId();
    }


	public Long getRootId() {
		if(upperId == null) {
			return id;
		} else {
			return rootId;
		}
	}
    
    private String toStringDateTime(LocalDateTime localDateTime) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	return Optional.ofNullable(localDateTime).map(formatter::format).orElse("");
    }
    
}