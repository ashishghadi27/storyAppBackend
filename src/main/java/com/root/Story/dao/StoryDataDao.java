package com.root.Story.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.root.Story.models.AssignmentQts;
import com.root.Story.models.AssignmentSet;
import com.root.Story.models.Categories;
import com.root.Story.models.MCQModel;
import com.root.Story.models.MCQSet;
import com.root.Story.models.Story;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Repository
public class StoryDataDao {

	@Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getCategories() {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from categories";
		try {
			NativeQuery<Categories> q = session.createSQLQuery(query);
			q.addEntity(Categories.class);
			List<Categories> list = q.getResultList();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "No Categories", null);
		}
		return template;
				
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getStories(int categoryId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from stories where categoryId = '%d'";
		query = String.format(query, categoryId);
		try {
			NativeQuery<Story> q = session.createSQLQuery(query);
			q.addEntity(Story.class);
			List<Story> list = q.getResultList();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
				
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getMCQSets(int storyId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from mcqSets where storyId = '%d'";
		query = String.format(query, storyId);
		try {
			NativeQuery<MCQSet> q = session.createSQLQuery(query);
			q.addEntity(MCQSet.class);
			List<MCQSet> list = q.getResultList();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;			
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getMCQs(int setId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from mcqs where setId = '%d'";
		query = String.format(query, setId);
		try {
			NativeQuery<MCQModel> q = session.createSQLQuery(query);
			q.addEntity(MCQModel.class);
			List<MCQModel> list = q.getResultList();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;		
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getAssignmentSets(int storyId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from assignSets where storyId = '%d'";
		query = String.format(query, storyId);
		try {
			NativeQuery<AssignmentSet> q = session.createSQLQuery(query);
			q.addEntity(AssignmentSet.class);
			List<AssignmentSet> list = q.getResultList();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;		
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getAssignmentQts(int setId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from assignments where setId = '%d'";
		query = String.format(query, setId);
		try {
			NativeQuery<AssignmentQts> q = session.createSQLQuery(query);
			q.addEntity(AssignmentQts.class);
			List<AssignmentQts> list = q.getResultList();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;		
	}
	
}
