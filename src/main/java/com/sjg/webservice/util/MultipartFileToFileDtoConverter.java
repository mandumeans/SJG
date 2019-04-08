package com.sjg.webservice.util;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

import com.sjg.webservice.dto.files.FilesSaveRequestDto;

public class MultipartFileToFileDtoConverter implements Converter<MultipartFile, FilesSaveRequestDto> {
	@Override
	public FilesSaveRequestDto convert(MultipartFile sourceFile){
		String sourceFileName = sourceFile.getOriginalFilename();
    	String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
    	
    	File destinationFile;
    	String destinationFileName, destinationFileFullName;
    	
    	//File Save
    	do {
    		destinationFileName = RandomStringUtils.randomAlphanumeric(32);
    		destinationFileFullName = destinationFileName + "." + sourceFileNameExtension;
    		destinationFile = new File("C:/attachments/" + destinationFileFullName);    		
    	} while (destinationFile.exists());
    	destinationFile.getParentFile().mkdirs();
    	
    	//DB save
    	FilesSaveRequestDto dto = new FilesSaveRequestDto();
    	dto.setOrgFileName(sourceFileName);
    	dto.setRealFileName(destinationFileName);
    	dto.setExt(sourceFileNameExtension);
    	dto.setFileSize(sourceFile.getSize());
    	dto.setFile(destinationFile);
    	dto.setMultiPartfile(sourceFile);
    	return dto;
	}
}
