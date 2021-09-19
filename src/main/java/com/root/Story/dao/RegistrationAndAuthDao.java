package com.root.Story.dao;

import java.text.DecimalFormat;
import java.util.Random;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.root.Story.models.User;
import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.responseTemplates.OtpTemplate;
import com.root.Story.utils.MailSender;

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
	
	public BaseResponseTemplate getOtp(String email) {
		String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
		if(MailSender.sendMail(otp, email)) {
			OtpTemplate template = new OtpTemplate(otp);
			return new BaseResponseTemplate(HttpStatus.OK, "Otp Mailed Successfully", template);
		}
		return new BaseResponseTemplate(HttpStatus.OK, "Otp Sent Failure", null);
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate updatePass(String email,String password) {
		
		BaseResponseTemplate template;
		
		Session session = factory.getCurrentSession();
		String query = "update users set password = '%s' where email = '%s'";
		query = String.format(query, password, email);
		try {
			NativeQuery<User> q = session.createSQLQuery(query);
			q.addEntity(User.class);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(NoResultException e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Password Update Failed", null);
		}
		catch (Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause() + " " + e.getMessage() + " \n " + e.getStackTrace(), null);
			
		}
		
		return template;
	}
}
