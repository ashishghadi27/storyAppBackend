package com.root.Story.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.root.Story.dao.UserOpsDao;
import com.root.Story.models.AssignmentAnswer;
import com.root.Story.models.AssignmentMarks;
import com.root.Story.models.MCQAnswer;
import com.root.Story.models.MCQMarks;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Service
public class UserOpsService {

	@Autowired
	private UserOpsDao dao;
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> saveUsersAnswer(MCQAnswer answer){
		return new ResponseEntity<BaseResponseTemplate>(dao.saveAnswer(answer), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> saveAssignmentAnswer(AssignmentAnswer answer){
		return new ResponseEntity<BaseResponseTemplate>(dao.saveAssignmentAnswer(answer), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> saveMCQSetMarks(MCQMarks marks){
		return new ResponseEntity<BaseResponseTemplate>(dao.saveMCQSetMarks(marks), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> saveAssignmentSetMarks(AssignmentMarks marks){
		return new ResponseEntity<BaseResponseTemplate>(dao.saveAssignmentSetMarks(marks), HttpStatus.OK);
	}
	
}
