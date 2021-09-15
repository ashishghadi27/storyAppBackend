package com.root.Story.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignSets")
public class AssignmentSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "setId")
	private Integer setId;

	@Column(name = "assignName")
	private String assignName;

	@Column(name = "storyId")
	private Integer storyId;

	public AssignmentSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssignmentSet(Integer setId, String assignName, Integer storyId) {
		super();
		this.setId = setId;
		this.assignName = assignName;
		this.storyId = storyId;
	}

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public String getAssignName() {
		return assignName;
	}

	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}

	public Integer getStoryId() {
		return storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

}
