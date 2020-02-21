package com.sjg.webservice.web;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjg.webservice.dto.files.FilesSaveRequestDto;
import com.sjg.webservice.dto.files.UploadAttachFileResponseDto;
import com.sjg.webservice.dto.posts.PostsSaveRequestDto;
import com.sjg.webservice.dto.scraps.ScrapsSaveRequestDto;
import com.sjg.webservice.service.FilesService;
import com.sjg.webservice.service.PostsService;
import com.sjg.webservice.service.ScrapsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private ScrapsService scrapsService;
    private FilesService filesService;
	
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
    	return postsService.save(dto);
    }
    
    @PostMapping("/scraps")
    public boolean saveScraps(@RequestBody ScrapsSaveRequestDto dto) {
    	scrapsService.save(dto);
		return true;
    }
    
    @PostMapping("/upload")
    public ResponseEntity<?> uploadAttachment(@RequestParam FilesSaveRequestDto sourceFile) throws IOException {
    	(sourceFile.getMultiPartfile()).transferTo(sourceFile.getFile());
    	UploadAttachFileResponseDto response = new UploadAttachFileResponseDto(filesService.save(sourceFile));
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}