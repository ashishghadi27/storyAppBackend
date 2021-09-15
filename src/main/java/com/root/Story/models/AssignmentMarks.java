package com.root.Story.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class AssignmentMarks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "setId")
	private Integer setId;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "marks")
	private Integer marks;

	public AssignmentMarks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignmentMarks(Integer id, Integer setId, Integer userId, Integer marks) {
		super();
		this.id = id;
		this.setId = setId;
		this.userId = userId;
		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "MCQMarks [id=" + id + ", setId=" + setId + ", userId=" + userId + ", marks=" + marks + "]";
	}

}
