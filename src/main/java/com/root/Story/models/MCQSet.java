package com.root.Story.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mcqSets")
public class MCQSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "setID")
	private Integer setId;

	@Column(name = "setName")
	private String setName;

	@Column(name = "storyId")
	private Integer storyId;

	public MCQSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MCQSet(Integer setId, String setName, Integer storyId) {
		super();
		this.setId = setId;
		this.setName = setName;
		this.storyId = storyId;
	}

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public Integer getStoryId() {
		return storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

}
