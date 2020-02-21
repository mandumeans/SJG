package com.sjg.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjg.webservice.domain.scrap.ScrapsRepository;
import com.sjg.webservice.dto.scraps.ScrapsMainResponseDto;
import com.sjg.webservice.dto.scraps.ScrapsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ScrapsService {
	private ScrapsRepository scrapsRepository;
	
	@Transactional(readOnly = true)
	public List<ScrapsMainResponseDto> findAllDesc(String author){
		List<ScrapsMainResponseDto> scrapList = scrapsRepository.findAllDesc(author).map(ScrapsMainResponseDto::new).collect(Collectors.toList());
		return scrapList;
	}
	

	@Transactional
	public void save(ScrapsSaveRequestDto dto) {
		scrapsRepository.save(dto.toEntity());
	}
}