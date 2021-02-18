package com.videos.application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Date;

import com.videos.domain.*;
import com.videos.application.*;

public class VideoCreator {
	
	private static String title;
	private static String url;
	private static Videos video;
	private static TagCreator tCreator = new TagCreator();
	private static List <Videos> videos = new ArrayList <Videos>();
	
	public VideoCreator () {
	}
	
	public void createVideo () {
				
		do {
			
			title = JOptionPane.showInputDialog("Enter the video's title: ");		
			url = JOptionPane.showInputDialog("Enter the video url: ");	
			
			// Checking data in case of null fields.
			try {
				checkData(title, url);
			} catch (NullPointerException e){
				JOptionPane.showMessageDialog(null, "ERROR FOUND. You must enter all the requested data."
						+ "\nException type: " + e.getClass().getName());	
			}			
			
		} while (title.length() < 1 || url.length() < 1);
		
		// Creating and printing video.
		video = new Videos (title, url);
					
		// Adding tags.
		tCreator.createTag(video);
		
		// Printing videos.
		videos.add(video);		
	}
	
	
	// Checking if all the fields are entered.
	public void checkData (String title, String url ) throws NullPointerException {
		
		if (title.length() < 1 || url.length() < 1) 
			throw new NullPointerException();
		
	}
	
	// Setting and getting the video status at the moment of check.
	public String getVideos() {
		Date checkStatus =  new Date();
		String videoList = "";
		for (Videos v: videos) {			
			v.setStatus(checkStatus);
			videoList = videoList + v + v.getStatus();			
		}
		return videoList;
		
	}
	
	// Getting the videos list size.
	public String getVideosSize() {
		return "\nYou have " + videos.size() + " videos.";
	}
	
	
	
}
