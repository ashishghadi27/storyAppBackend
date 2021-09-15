package com.root.Story.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.root.Story.dao.RegistrationAndAuthDao;
import com.root.Story.models.User;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Service
public class RegistrationAndAuthService {

	@Autowired
	private RegistrationAndAuthDao dao;
	
	@Transactional
	public ResponseEntity<BaseResponseTemplate> register(User user){
		return new ResponseEntity<BaseResponseTemplate>(dao.startRegistration(user), HttpStatus.OK);
	}
	
	public ResponseEntity<BaseResponseTemplate> login(String email, String password){
		return new ResponseEntity<BaseResponseTemplate>(dao.authenticate(email, password), HttpStatus.OK);
	}
	
}
