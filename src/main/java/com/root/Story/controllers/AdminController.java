package com.root.Story.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.Story.models.AssignmentQts;
import com.root.Story.models.AssignmentSet;
import com.root.Story.models.Categories;
import com.root.Story.models.MCQModel;
import com.root.Story.models.MCQSet;
import com.root.Story.models.Story;
import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.service.AdminOperationsService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminOperationsService service;
	
	@PostMapping("/createCategory") 
	public ResponseEntity<BaseResponseTemplate> createCategory(@RequestBody Categories categoryBody){
		return service.createCategories(categoryBody);
	}
	
	@PostMapping("/addStory") 
	public ResponseEntity<BaseResponseTemplate> addStory(@RequestBody Story story){
		ResponseEntity<BaseResponseTemplate> response = service.addStory(story);
		System.out.println("Response: " + response);
		return response;
	}
	
	@PostMapping("/createMcqSet") 
	public ResponseEntity<BaseResponseTemplate> createMCQSet(@RequestBody MCQSet set){
		return service.createMCQSet(set);
	}
	
	@PostMapping("/addMcq") 
	public ResponseEntity<BaseResponseTemplate> addMCQToSet(@RequestBody MCQModel mcq){
		return service.addMCQToSet(mcq);
	}
	
	@PostMapping("/createAssignmentSet") 
	public ResponseEntity<BaseResponseTemplate> createAssignmentSet(@RequestBody AssignmentSet set){
		return service.createAssignmentSet(set);
	}
	
	@PostMapping("/addAssignmentQts") 
	public ResponseEntity<BaseResponseTemplate> addAssignmentQts(@RequestBody AssignmentQts qts){
		return service.addAssignmentToSet(qts);
	}
	
	@DeleteMapping("/deleteCategory")
	public ResponseEntity<BaseResponseTemplate> deleteCategory(@RequestParam("categoryId") Integer categoryId) {
		return service.deleteCategory(categoryId);
	}

	@DeleteMapping("/deleteStory")
	public ResponseEntity<BaseResponseTemplate> deleteStory(@RequestParam("storyId") Integer storyId) {
		return service.deleteStory(storyId);
	}
	
	@DeleteMapping("/deleteMCQSet")
	public ResponseEntity<BaseResponseTemplate> deleteMCQSet(@RequestParam("setId") Integer setId) {
		return service.deleteMCQSet(setId);
	}
	
	@DeleteMapping("/deleteMCQ")
	public ResponseEntity<BaseResponseTemplate> deleteMCQ(@RequestParam("mcqId") Integer mcqId) {
		return service.deleteMCQ(mcqId);
	}
	
	@DeleteMapping("/deleteAssignmentSet")
	public ResponseEntity<BaseResponseTemplate> deleteAssignmentSet(@RequestParam("setId") Integer setId) {
		return service.deleteAssignmentSet(setId);
	}
	
	@DeleteMapping("/deleteAssignmentQts")
	public ResponseEntity<BaseResponseTemplate> deleteAssignmentQts(@RequestParam("quesId") Integer quesId) {
		return service.deleteAssignmentQts(quesId);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<BaseResponseTemplate> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/getMCQSetsByUser")
	public ResponseEntity<BaseResponseTemplate> getMCQSetsByUser(@RequestParam("userId") String userId) {
		return service.getMCQSetsByUser(userId);
	}
	
}
