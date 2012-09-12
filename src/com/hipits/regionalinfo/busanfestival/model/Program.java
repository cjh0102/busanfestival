package com.hipits.regionalinfo.busanfestival.model;

public class Program {
	
	private String sectionName;
	private String title;
	private String place;
	private String date;
	private int imageViewId;
	
	
	public Program(String title, String place, String date, int imageViewId, String sectionName) {
		super();
		this.sectionName = sectionName;
		this.title = title;
		this.place = place;
		this.date = date;
		this.imageViewId = imageViewId;
	}
	
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getImageViewId() {
		return imageViewId;
	}
	public void setImageViewId(int imageViewId) {
		this.imageViewId = imageViewId;
	}
}
