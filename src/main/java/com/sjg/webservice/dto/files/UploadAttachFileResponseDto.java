package com.sjg.webservice.dto.files;

import com.sjg.webservice.domain.files.Files;
import lombok.Getter;

@Getter
public class UploadAttachFileResponseDto {

	private Long id;
	
	private String orgFileName;
	
	private String realFileName;
	
	private String ext;
	
	private Long fileSize;
	
	
	public UploadAttachFileResponseDto(Files dto) {
		id = dto.getId();
		orgFileName = dto.getOrgFileName();
		realFileName = dto.getRealFileName();
		ext = dto.getExt();
		fileSize = dto.getFileSize();
	}
}
