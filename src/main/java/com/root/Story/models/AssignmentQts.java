package com.root.Story.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignments")
public class AssignmentQts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quesId")
	private Integer quesId;

	@Column(name = "ques")
	private String ques;

	@Column(name = "quesAns")
	private String answer;

	@Column(name = "marks")
	private Integer marks;

	@Column(name = "setId")
	private Integer setId;

	public AssignmentQts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignmentQts(Integer quesId, String ques, String answer, Integer marks, Integer setId) {
		super();
		this.quesId = quesId;
		this.ques = ques;
		this.answer = answer;
		this.marks = marks;
		this.setId = setId;
	}

	public Integer getQuesId() {
		return quesId;
	}

	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

}
