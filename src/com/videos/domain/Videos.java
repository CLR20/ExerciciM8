package com.videos.domain;
import java.util.List;
import java.util.ArrayList;

public class Videos {
	
	String title;
	String url;
	String tag;
	ArrayList <String> tags = new ArrayList <String>();

	public Videos (String title, String url) {
		this.title = title;
		this.url = url;
	}
	
	// Adding and getting the tags.
	public void addTag (String tag) {
		this.tag = tag;
		tags.add(tag);
	}
	
	public String getTags() {
		return tags.toString();
	}
	
	// Overriding toString method.
	public String toString () {
		return "\nVIDEO: \n\tTitle: " + title + "\n\tURL: " + url + "\n\tTags: " + tags;
	}

}
