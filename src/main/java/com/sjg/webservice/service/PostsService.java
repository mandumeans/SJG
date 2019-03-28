package com.sjg.webservice.service;

import java.util.Comparator;
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
		if(dto.getUpperId() == null) {
			//부모 노드 저장
			PostsSaveRequestDto result = getLeftRightValue(dto);
			dto.setLft(result.getLft());
			dto.setRgt(result.getRgt());
		} else {
			//자식 노드 저장시 부모 정보 조회
			PostsMainResponseDto parent = postsRepository.findPostById(dto.getUpperId());
			Long rootId = null;
			if(parent.getRootId() == null) {
				rootId = parent.getId();
			} else {
				rootId = parent.getRootId();
			}
			
			//루트이하의 모든 노드를 좌측으로 밀음
			postsRepository.updateLeft(rootId, parent.getLft());
			postsRepository.updateRight(rootId, parent.getLft());
			dto.setRootId(rootId);
			dto.setLft(parent.getLft() + 1);
			dto.setRgt(parent.getLft() + 2);
		}
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional(readOnly = true)
	private PostsSaveRequestDto getLeftRightValue(PostsSaveRequestDto input) {
		Long left = 0L, right = 0L;
		PostsSaveRequestDto result = new PostsSaveRequestDto();
		List<PostsMainResponseDto> postList = postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
		
		if(postList.size() == 0) {
			//최초 부모 노드 저장시
			left = 1L;
			right= 2L;
		} else {
			//최초 이후 부모 노드 저장시
			List<PostsMainResponseDto> rootList = postList.stream().filter(post->post.getRootId() == null).sorted(Comparator.comparing(PostsMainResponseDto::getId).reversed()).collect(Collectors.toList());
			
			if(rootList.size() > 0) {
				left = rootList.get(0).getLft() + 100L;
				right = rootList.get(0).getLft() + 101L;
			}
		}
		
		result.setLft(left);
		result.setRgt(right);
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		List<PostsMainResponseDto> postList = postsRepository.findAllPostsAsTree().map(PostsMainResponseDto::new).collect(Collectors.toList());
		return postList;
	}
}