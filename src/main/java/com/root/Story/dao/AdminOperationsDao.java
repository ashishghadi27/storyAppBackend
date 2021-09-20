package com.root.Story.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
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
import com.root.Story.models.User;
import com.root.Story.models.UsersScoreOfEachSet;
import com.root.Story.responseTemplates.BaseResponseTemplate;

@Repository
public class AdminOperationsDao {

	@Autowired
	private SessionFactory factory;
	
	public BaseResponseTemplate createCategories(Categories category) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(category);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", category);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
	}
	
	@SuppressWarnings("deprecation")
	public BaseResponseTemplate addStory(Story story ) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(story);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", story);
			
		}
		catch(Exception e) {
			System.out.println("Here");
			story.setStoryId(-1);
			session.setFlushMode(FlushMode.MANUAL);
			
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		
		return template;
	}

	public BaseResponseTemplate createMCQSet(MCQSet set) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(set);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", set);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}

	public BaseResponseTemplate addMCQToSet(MCQModel mcq) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(mcq);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", mcq);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}

	public BaseResponseTemplate createAssignmentSet(AssignmentSet set) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(set);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", set);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}

	public BaseResponseTemplate addAssignmentToSet(AssignmentQts qts) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		try {
			session.save(qts);
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", qts);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate deleteCategory(int categoryId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "delete from categories where categoryId = '%d'";
		query = String.format(query, categoryId);
		try {
			NativeQuery<Categories> q = session.createSQLQuery(query);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate deleteStory(int storyId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "delete from stories where storyId = '%d'";
		query = String.format(query, storyId);
		try {
			NativeQuery<Story> q = session.createSQLQuery(query);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate deleteMCQSet(int setId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "delete from mcqSets where setID = '%d'";
		query = String.format(query, setId);
		try {
			NativeQuery<MCQSet> q = session.createSQLQuery(query);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate deleteAssignmentSet(int setId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "delete from assignSets where setID = '%d'";
		query = String.format(query, setId);
		try {
			NativeQuery<AssignmentSet> q = session.createSQLQuery(query);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate deleteMCQ(int mcqId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "delete from mcqs where quesId = '%d'";
		query = String.format(query, mcqId);
		try {
			NativeQuery<MCQModel> q = session.createSQLQuery(query);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate deleteAssignment(int quesId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "delete from assignments where quesId = '%d'";
		query = String.format(query, quesId);
		try {
			NativeQuery<AssignmentQts> q = session.createSQLQuery(query);
			q.executeUpdate();
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", null);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings("unchecked")
	public BaseResponseTemplate getAllUsers() {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select * from users where isAdmin = 0";
		try {
			NativeQuery<User> q = session.createSQLQuery(query);
			q.addEntity(User.class);
			List<User> list = q.getResultList(); 
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseResponseTemplate getMCQSetsByUser(String userId) {
		BaseResponseTemplate template;
		Session session = factory.getCurrentSession();
		String query = "select ms.storyId, s.storyName, ms.setId, ms.setName, sum(m.marks) as marks "
				+ "from mcqSets ms, mcqAnswers ma, stories s, mcqs m "
				+ "where ma.userId = '%s' "
				+ "and ms.setId = ma.setId "
				+ "and ms.setId = m.setId "
				+ "and trim(lower(ma.answer)) = trim(lower(m.quesAns)) "
				+ "and ms.storyId = s.storyId order by ms.setId;";
		query = String.format(query, userId);
		try {
			NativeQuery q = session.createSQLQuery(query);
			List<Object[]> rows = q.getResultList();
			System.out.println("here");
			List<UsersScoreOfEachSet> list = new ArrayList<UsersScoreOfEachSet>();
			//System.out.println("1:" + list.get(0).getStoryName());
			for(Object[] row : rows) {
				UsersScoreOfEachSet scoreSet = new UsersScoreOfEachSet();
				scoreSet.setStoryId(row[0].toString());
				scoreSet.setStoryName(row[1].toString());
				scoreSet.setSetId(row[2].toString());
				scoreSet.setSetName(row[3].toString());
				scoreSet.setMarks(row[4].toString());
				list.add(scoreSet);
			}
			template = new BaseResponseTemplate(HttpStatus.OK, "Success", list);
		}
		catch(Exception e) {
			template = new BaseResponseTemplate(HttpStatus.OK, "Error : " + e.getCause(), null);
		}
		return template;
	}
	
}
