package com.root.Story.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.service.FileStorageService;
import com.root.Story.service.StoryDataService;

@RestController
@RequestMapping("/story")
public class StoryController {
	
	@Autowired
	private StoryDataService service;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@GetMapping("/categories")
	public ResponseEntity<BaseResponseTemplate> getCategories(){
		return service.getCategories();
	}
	
	@GetMapping("/getStories")
	public ResponseEntity<BaseResponseTemplate> getStories(@RequestParam("categoryId") Integer categoryId){
		return service.getStories(categoryId);
	}
	
	@GetMapping("/getMcqSets")
	public ResponseEntity<BaseResponseTemplate> getMCQSets(@RequestParam("storyId") Integer storyId){
		return service.getMCQSets(storyId);
	}
	
	@GetMapping("/getMcqs")
	public ResponseEntity<BaseResponseTemplate> getMCQs(@RequestParam("setId") Integer setId){
		return service.getMCQs(setId);
	}
	
	@GetMapping("/getAssignmentSets")
	public ResponseEntity<BaseResponseTemplate> getAssignmentSets(@RequestParam("storyId") Integer storyId){
		return service.getAssignmentSets(storyId);
	}
	
	@GetMapping("/getAssignments")
	public ResponseEntity<BaseResponseTemplate> getAssignmentQts(@RequestParam("setId") Integer setId){
		return service.getAssignmentQts(setId);
	}
	
	@PostMapping("/uploadImage")
    public ResponseEntity<BaseResponseTemplate> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileStorageService.storeFile(file);
    }
	
	@GetMapping("/video/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
}
