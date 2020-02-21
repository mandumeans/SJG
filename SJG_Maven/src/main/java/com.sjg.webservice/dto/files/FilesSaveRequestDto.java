package com.sjg.webservice.dto.files;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.sjg.webservice.domain.files.Files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilesSaveRequestDto {
	
	private String orgFileName;
	
	private String realFileName;
	
	private String ext;
	
	private Long fileSize;
	
	private File file;
	
	private MultipartFile multiPartfile;
	
	public Files toEntity() {
		return Files.builder()
				.orgFileName(orgFileName)
    			.realFileName(realFileName)
    			.ext(ext)
    			.fileSize(fileSize)
				.build();
	}
}