package com.root.Story.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.root.Story.models.AssignmentAnswer;
import com.root.Story.models.AssignmentMarks;
import com.root.Story.models.MCQAnswer;
import com.root.Story.models.MCQMarks;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Repository
public class UserOpsDao {

	@Autowired
	private SessionFactory factory;
	
	public BaseResponseTemplate saveAnswer(MCQAnswer answer) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(answer);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", answer);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
	}
	
	public BaseResponseTemplate saveAssignmentAnswer(AssignmentAnswer answer) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(answer);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", answer);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
	}
	
	public BaseResponseTemplate saveMCQSetMarks(MCQMarks marks) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(marks);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", marks);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
	}
	
	public BaseResponseTemplate saveAssignmentSetMarks(AssignmentMarks marks) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(marks);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", marks);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
	}
	
}
