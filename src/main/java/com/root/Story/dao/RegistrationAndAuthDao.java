package com.root.Story.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.root.Story.models.User;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Repository
public class RegistrationAndAuthDao {

	@Autowired
	private SessionFactory factory;
	
	public BaseResponseTemplate startRegistration(User user) {
		
		BaseResponseTemplate template;
		
		Session session = factory.getCurrentSession();
		
		try {
			session.save(user);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", user);
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage() + " " + e.getCause());
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
		
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate authenticate(String email,String password) {
		
		BaseResponseTemplate template;
		
		Session session = factory.getCurrentSession();
		String query = "select * from users where email = '%s'";
		query = String.format(query, email);
		try {
			NativeQuery<User> q = session.createSQLQuery(query);
			q.addEntity(User.class);
			User user = q.getSingleResult();
			System.out.println("Here");
			if(user == null)
				template = new BaseResponseTemplate(HttpStatus.OK, "User Not Found", null);
			else if(user.getPassword().equals(password))
				template = new BaseResponseTemplate(HttpStatus.OK, "Success", user);
			else template = new BaseResponseTemplate(HttpStatus.OK, "Invalid Username or password", null);
		}
		catch(NoResultException e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "User Not Found", null);
		}
		catch (Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause() + " " + e.getMessage() + " \n " + e.getStackTrace(), null);
			
		}
		
		return template;
	}
	
}
