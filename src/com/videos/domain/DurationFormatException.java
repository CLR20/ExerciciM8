package com.videos.domain;

//Creating an exception type manually.
public class DurationFormatException extends Exception {
	
	public DurationFormatException () {}
	
	public DurationFormatException (String message) {
	
		super ("The format for duration must be M:SS or MM:SS.");
	}

}
