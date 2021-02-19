package com.videos.domain;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Videos {
	
	private String title;
	private String url;
	private String tag;
	protected Status status;
	protected Date created; 
	
	ArrayList <String> tags = new ArrayList <String>();

	public Videos (String title, String url) {
		this.title = title;
		this.url = url;
		created = new Date();
	}
	
	// Adding and getting the tags.
	public void addTag (String tag) {
		this.tag = tag;
		tags.add(tag);
	}
	
	public String getTags() {
		return tags.toString();
	}
	
	// Adding and getting the status with the date of check. Status coming from Enum Class.
	public enum Status {
		UPLOADING,
		VERIFYING,
		PUBLIC
	}
	
	public void setStatus(Date checkStatus) {
		double timeLapse = (checkStatus.getTime() - created.getTime()) * 0.001;
		if (timeLapse < 10) {
			status = Status.UPLOADING;			
		}
		else if (timeLapse < 30) {
			status = Status.VERIFYING;			
		}
		else {
			status = Status.PUBLIC;			
		}
	}

	public String getStatus() {
		return "\nStatus: " + status;
	}
			
	// Overriding toString method.
	public String toString () {
		
		return "\nVIDEO: \n\tTitle: " + title + "\n\tURL: " + url
				+ "\n\tCreated: " + created + "\n\tTags: " + tags;
	}

}
