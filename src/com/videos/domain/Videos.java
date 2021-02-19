package com.videos.domain;
import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Videos {
	
	private String title;
	private String url;
	private String duration;
	private String tag;
	protected Enum uploadStatus;
	protected Double seconds;
	protected Enum playingStatus;
	protected Date created; 
	ArrayList <String> tags = new ArrayList <String>();
	private String actualVideo;
	private Double actualSeconds;
	
	protected HashMap<String, Double> titleAndSeconds =  new HashMap<String, Double>();
	protected static HashMap<String, Enum> playingState =  new HashMap<String, Enum>();

	public Videos (String title, String url, String duration) {
		this.title = title;
		this.url = url;
		this.duration = duration; 
		String s [] = duration.split(":");
		seconds = (Double.parseDouble(s[0]))*60 + Double.parseDouble(s[1]);
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
	public enum UploadStatus {
		UPLOADING,
		VERIFYING,
		PUBLIC
	}
	
	public void setStatus(Date checkStatus) {
		double timeLapse = (checkStatus.getTime() - created.getTime()) * 0.001;
		if (timeLapse < 30) {
			uploadStatus = UploadStatus.UPLOADING;			
		}
		else if (timeLapse < 60) {
			uploadStatus = UploadStatus.VERIFYING;			
		}
		else {
			uploadStatus = UploadStatus.PUBLIC;			
		}
	}

	public String getStatus() {
		return "\nUpload status: " + uploadStatus;
	}
	
	// Adding, setting and changing the playing status.
	public enum PlayingStatus {
		STOPPED,
		PAUSED,
		PLAYING
	}
	
	public void setSecondsAndPlaying (HashMap <String, String> videosForPlay) {		
		for (String s: videosForPlay.keySet()) {
			String time = videosForPlay.get(s);
			String split [] = time.split(":");
			seconds = (Double.parseDouble(split[0]))*60 + Double.parseDouble(split[1]);
			titleAndSeconds.put(s, seconds);
			playingStatus = PlayingStatus.STOPPED;
			playingState.put(s, playingStatus);
		}		
	}
	
	public String getPlayingState (Videos v) {
		return "Playing state: " + playingState.get(v.title);
	}
	
	public static String getAllStates () {
		return "PLAYING STATES: " + playingState;
	}
	
	public void changePlaying (String name, int option) {		
		for (String s: titleAndSeconds.keySet()) {
			if (s.equals(name)) {
				actualVideo = s;
				actualSeconds = titleAndSeconds.get(s);
			} 
		}
		if (option == 1) {
			Date startPlay = new Date();
			playingState.replace(actualVideo, PlayingStatus.PLAYING);
		}
		else if (option == 2) {
			playingState.replace(actualVideo, PlayingStatus.PAUSED);
		}
		else if (option == 3) {
			playingState.replace(actualVideo, PlayingStatus.STOPPED);
		}
	}
		
	// Overriding toString method.
	public String toString () {
		
		return "\nVIDEO: \n\tTitle: " + title + "\n\tURL: " + url
				+ "\n\tCreated: " + created + "\n\tTags: " + tags 
				+  "\nDuration: " + duration; 
	}

}
