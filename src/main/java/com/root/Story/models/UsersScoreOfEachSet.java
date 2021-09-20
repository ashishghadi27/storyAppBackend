package com.root.Story.models;


public class UsersScoreOfEachSet {


	private String setId;
	private String setName;
	private String marks;
	private String storyName;
	private String storyId;

	public UsersScoreOfEachSet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersScoreOfEachSet(String setId, String setName, String marks, String storyName, String storyId) {
		super();
		this.setId = setId;
		this.setName = setName;
		this.marks = marks;
		this.storyName = storyName;
		this.storyId = storyId;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	@Override
	public String toString() {
		return "UsersScoreOfEachSet [setId=" + setId + ", setName=" + setName + ", marks=" + marks + ", storyName="
				+ storyName + ", storyId=" + storyId + "]";
	}

	
	
}
