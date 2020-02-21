package com.sjg.webservice.domain.files;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sjg.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Files extends BaseTimeEntity{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String orgFileName;
	
	private String realFileName;
	
	private String ext;
	
	private Long fileSize;
	
	@Builder
	public Files(String orgFileName, String realFileName, String ext, Long fileSize) {
		this.orgFileName = orgFileName;
		this.realFileName = realFileName;
		this.ext = ext;
		this.fileSize = fileSize;
	}
}