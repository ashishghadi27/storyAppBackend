package com.root.Story.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.Story.models.AssignmentAnswer;
import com.root.Story.models.AssignmentMarks;
import com.root.Story.models.MCQAnswer;
import com.root.Story.models.MCQMarks;
import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.service.UserOpsService;

@RestController
@RequestMapping("/users")
public class UserOpsController {

	@Autowired
	private UserOpsService service;
	
	@PostMapping("/saveMcqAnswer")
	public ResponseEntity<BaseResponseTemplate> saveUsersAnswer(@RequestBody MCQAnswer answer){
		return service.saveUsersAnswer(answer);
	}
	
	@PostMapping("/saveAssignmentAnswer")
	public ResponseEntity<BaseResponseTemplate> saveAssignmentAnswer(@RequestBody AssignmentAnswer answer){
		return service.saveAssignmentAnswer(answer);
	}
	
	@PostMapping("/saveMCQSetMarks")
	public ResponseEntity<BaseResponseTemplate> saveMCQSetMarks(@RequestBody MCQMarks marks){
		return service.saveMCQSetMarks(marks);
	}
	
	@PostMapping("/saveAssignmentSetMarks")
	public ResponseEntity<BaseResponseTemplate> saveAssignmentSetMarks(@RequestBody AssignmentMarks marks){
		return service.saveAssignmentSetMarks(marks);
	}
	
}
