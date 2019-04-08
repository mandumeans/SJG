package com.sjg.webservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjg.webservice.domain.files.Files;
import com.sjg.webservice.domain.files.FilesRepository;
import com.sjg.webservice.dto.files.FilesSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FilesService {
	
	private FilesRepository filesRepository;

	@Transactional
	public Files save(FilesSaveRequestDto dto) {
		return filesRepository.save(dto.toEntity());
	}
}