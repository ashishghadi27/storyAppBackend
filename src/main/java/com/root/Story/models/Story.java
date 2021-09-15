package com.root.Story.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stories")
public class Story {

	@Id
	@Column(name = "storyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storyId;

	@Column(name = "storyName")
	private String storyName;

	@Column(name = "categoryId")
	private String categoryId;

	@Column(name = "storySummary")
	private String storySummary;

	@Column(name = "storyContent")
	private String content;

	@Column(name = "featuredImage")
	private String featuredLink;

	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Story(Integer storyId, String storyName, String categoryId, String storySummary, String content,
			String featuredLink) {
		super();
		this.storyId = storyId;
		this.storyName = storyName;
		this.categoryId = categoryId;
		this.storySummary = storySummary;
		this.content = content;
		this.featuredLink = featuredLink;
	}

	public Integer getStoryId() {
		return storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getStorySummary() {
		return storySummary;
	}

	public void setStorySummary(String storySummary) {
		this.storySummary = storySummary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFeaturedLink() {
		return featuredLink;
	}

	public void setFeaturedLink(String featuredLink) {
		this.featuredLink = featuredLink;
	}

}
