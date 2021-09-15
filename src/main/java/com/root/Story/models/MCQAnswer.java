package com.root.Story.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcqAnswers")
public class MCQAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ansId")
	private Integer ansId;

	@Column(name = "answer")
	private String answer;

	@Column(name = "setId")
	private Integer setId;

	@Column(name = "quesId")
	private Integer quesId;

	@Column(name = "userId")
	private Integer userId;

	public MCQAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MCQAnswer(Integer ansId, String answer, Integer setId, Integer quesId, Integer userId) {
		super();
		this.ansId = ansId;
		this.answer = answer;
		this.setId = setId;
		this.quesId = quesId;
		this.userId = userId;
	}

	public Integer getAnsId() {
		return ansId;
	}

	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public Integer getQuesId() {
		return quesId;
	}

	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MCQAnswer [ansId=" + ansId + ", answer=" + answer + ", setId=" + setId + ", quesId=" + quesId
				+ ", userId=" + userId + "]";
	}

}
