package com.sjg.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		List<PostsMainResponseDto> postList = postsRepository.findAllDesc()
												.map(PostsMainResponseDto::new)
												.collect(Collectors.toList());
		Long nowDept = 0L;
		List<PostsMainResponseDto> rootList = postList.stream().filter(post->post.getUpperId() == null).collect(Collectors.toList());
		
		for(PostsMainResponseDto root:rootList) {
			List<PostsMainResponseDto> leafList = postList.stream().filter(post->post.getUpperId() == root.getId()).collect(Collectors.toList());
			for(PostsMainResponseDto leaf:leafList) {
				if(nowDept == 0) {
					leaf.setRootId(root.getId());
				} else {
					leaf.setRootId(root.getUpperId());
				}
				leaf.setDepth(nowDept);
			}
			nowDept++;
		}
		
				//.sorted(Comparator.comparing(Posts::getId))
				//.sorted(Comparator.comparing(Posts::getLev).reversed())
		 return postList;
	}
}