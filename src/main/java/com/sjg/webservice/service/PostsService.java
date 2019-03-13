package com.sjg.webservice.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjg.webservice.domain.posts.Posts;
import com.sjg.webservice.domain.posts.PostsRepository;
import com.sjg.webservice.domain.posts.PostsSaveRequestDto;
import com.sjg.webservice.dto.posts.PostsMainResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		return postsRepository.findAllDesc()
				.sorted(Comparator.comparing(Posts::getId))
				.sorted(Comparator.comparing(Posts::getLev).reversed())
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}