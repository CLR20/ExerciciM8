package com.videos.application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;

import com.videos.domain.*;
import com.videos.application.*;

public class VideoCreator {
	
	private static String title;
	private static String url;
	private static String duration;
	private static Videos video;
	private static TagCreator tCreator = new TagCreator();
	public static List <Videos> videos = new ArrayList <Videos>();
	protected int addVideoForPlay = 0;
	protected HashMap<String, String> videosForPlay = new HashMap <String, String>();
	protected String changePlay;
	protected int option;
	
	public VideoCreator () {
	}
	
	public void createVideo () {
				
		do {			
			title = JOptionPane.showInputDialog("Enter the video's title: ");		
			url = JOptionPane.showInputDialog("Enter the video url: ");	
			duration = JOptionPane.showInputDialog("Enter the video duration in minutes (exemple 3:14): ");	
			
			// Checking data in case of null fields.
			try {
				checkData(title, url, duration);
			} catch (NullPointerException e){
				JOptionPane.showMessageDialog(null, "ERROR FOUND. You must enter all the requested data."
						+ "\nException type: " + e.getClass().getName());	
			} catch (DurationFormatException dE) {
				JOptionPane.showMessageDialog(null, "The format for duration must be M:SS or MM:SS."
						+ "\nException type: " + dE.getClass().getName());
			}
		} while (title.length() < 1 || url.length() < 1 || duration.length() <1 || 
				! duration.matches("\\d{1,2}" + ":" + "\\d{1,2}"));
		
		// Creating and printing video.
		video = new Videos (title, url, duration);
					
		// Adding tags.
		tCreator.createTag(video);
		
		// Printing videos.
		videos.add(video);			
		
		// Preparing data for adding the chance to change the playing status.
		videosForPlay.put(title, duration);		
		video.setSecondsAndPlaying(videosForPlay);		
	}
	
	// Giving orders to change the playing status.
	public void setChangePlaying () {
		changePlay = JOptionPane.showInputDialog("Enter the video's title: ");
		option = Integer.parseInt(JOptionPane.showInputDialog("Enter an option: "
					+ "\n1 Play \n2 Pause \n3 Stop"));
		video.changePlaying(changePlay, option);
	}	
	
	// Checking if all the fields are entered.
	public void checkData (String title, String url, String duration) throws NullPointerException, 
							DurationFormatException {		
		if (title.length() < 1 || url.length() < 1 || duration.length() < 1) 
			throw new NullPointerException();
		if (! duration.matches("\\d{1,2}" + ":" + "\\d{1,2}")) {
			throw new DurationFormatException();
		}
	}
	
	// Setting and getting the video status at the moment of check.
	public String getVideos() {
		Date checkStatus =  new Date();
		String videoList = "";
		//video.setSecondsAndPlaying(videosForPlay);
		for (Videos v: videos) {			
			v.setStatus(checkStatus);
			v.getPlayingState(v);
			videoList = videoList + v + v.getStatus() + "\n" + v.getPlayingState(v);			
		}
		return videoList + "\n";		
	}
	
	// Getting playing status changed.
	public String getAllPlayingStates () {
		return Videos.getAllStates();
	}	
	
	// Getting the videos list size.
	public String getVideosSize() {
		return "\nYou have " + videos.size() + " videos.";
	}
	
	
	
}
