package com.root.Story.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.root.Story.dao.AdminOperationsDao;
import com.root.Story.models.AssignmentQts;
import com.root.Story.models.AssignmentSet;
import com.root.Story.models.Categories;
import com.root.Story.models.MCQModel;
import com.root.Story.models.MCQSet;
import com.root.Story.models.Story;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Service
public class AdminOperationsService {

	@Autowired
	private AdminOperationsDao dao;
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> createCategories(Categories category) {
		return new ResponseEntity<BaseResponseTemplate>(dao.createCategories(category), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<BaseResponseTemplate> addStory(Story story) {
		return new ResponseEntity<BaseResponseTemplate>(dao.addStory(story), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<BaseResponseTemplate> createMCQSet(MCQSet set) {
		return new ResponseEntity<BaseResponseTemplate>(dao.createMCQSet(set), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<BaseResponseTemplate> addMCQToSet(MCQModel mcq) {
		return new ResponseEntity<BaseResponseTemplate>(dao.addMCQToSet(mcq), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<BaseResponseTemplate> createAssignmentSet(AssignmentSet set) {
		return new ResponseEntity<BaseResponseTemplate>(dao.createAssignmentSet(set), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<BaseResponseTemplate> addAssignmentToSet(AssignmentQts qts) {
		return new ResponseEntity<BaseResponseTemplate>(dao.addAssignmentToSet(qts), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> deleteCategory(int categoryId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.deleteCategory(categoryId), HttpStatus.OK);
	}

	@Transactional
	public ResponseEntity<BaseResponseTemplate> deleteStory(int storyId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.deleteStory(storyId), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> deleteMCQSet(int setId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.deleteMCQSet(setId), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> deleteMCQ(int mcqId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.deleteMCQ(mcqId), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> deleteAssignmentSet(int setId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.deleteAssignmentSet(setId), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> deleteAssignmentQts(int quesId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.deleteAssignment(quesId), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getAllUsers() {
		return new ResponseEntity<BaseResponseTemplate>(dao.getAllUsers(), HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getMCQSetsByUser(String userId) {
		return new ResponseEntity<BaseResponseTemplate>(dao.getMCQSetsByUser(userId), HttpStatus.OK);
	}
	
}
