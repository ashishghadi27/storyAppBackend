package com.root.Story.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.root.Story.dao.StoryDataDao;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Service
public class StoryDataService {

	@Autowired
	private StoryDataDao dao;
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getCategories(){
		return new ResponseEntity<BaseResponseTemplate>(dao.getCategories(), HttpStatus.OK); 
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getStories(int categoryId){
		return new ResponseEntity<BaseResponseTemplate>(dao.getStories(categoryId), HttpStatus.OK); 
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getMCQSets(int storyId){
		return new ResponseEntity<BaseResponseTemplate>(dao.getMCQSets(storyId), HttpStatus.OK); 
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getMCQs(int setId){
		return new ResponseEntity<BaseResponseTemplate>(dao.getMCQs(setId), HttpStatus.OK); 
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getAssignmentSets(int storyId){
		return new ResponseEntity<BaseResponseTemplate>(dao.getAssignmentSets(storyId), HttpStatus.OK); 
	}
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> getAssignmentQts(int setId){
		return new ResponseEntity<BaseResponseTemplate>(dao.getAssignmentQts(setId), HttpStatus.OK); 
	}
	
}
