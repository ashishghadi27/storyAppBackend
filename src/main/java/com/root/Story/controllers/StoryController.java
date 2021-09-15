package com.root.Story.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.service.StoryDataService;

@RestController
@RequestMapping("/story")
public class StoryController {
	
	@Autowired
	private StoryDataService service;
	
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
	
	@GetMapping("/getMcqSets")
	public ResponseEntity<BaseResponseTemplate> getAssignmentSets(@RequestParam("storyId") Integer storyId){
		return service.getAssignmentSets(storyId);
	}
	
	@GetMapping("/getMcqs")
	public ResponseEntity<BaseResponseTemplate> getAssignmentQts(@RequestParam("setId") Integer setId){
		return service.getAssignmentQts(setId);
	}
	
}
