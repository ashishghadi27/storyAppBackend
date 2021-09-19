package com.root.Story.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.Story.models.AuthDataModel;
import com.root.Story.models.User;
import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.service.RegistrationAndAuthService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthAndRegistration {

	@Autowired
	private RegistrationAndAuthService service;
	
	@PostMapping("/register")
	public ResponseEntity<BaseResponseTemplate> register(@RequestBody User user){
		return service.register(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<BaseResponseTemplate> register(@RequestBody AuthDataModel data){
		return service.login(data.getEmail(), data.getPassword());
	}
	
	@GetMapping("/getOtp")
	public ResponseEntity<BaseResponseTemplate> getOtp(@RequestParam("email") String email ){
		return service.getOtp(email);
	}
	
	@PostMapping("/updatePass")
	public ResponseEntity<BaseResponseTemplate> updatePass(@RequestBody AuthDataModel data){
		return service.updatePass(data.getEmail(), data.getPassword());
	}
}
