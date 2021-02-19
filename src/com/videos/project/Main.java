package com.videos.project;

import com.videos.application.*;
import com.videos.domain.Videos;

import javax.swing.JOptionPane;

public class Main {
	
	public static UserCreator uCreator = new UserCreator();
	public static String videoAnswer;
	public static String playAnswer;
	public static VideoCreator vCreator = new VideoCreator();
	
	public static void main (String [] args) {

		JOptionPane.showMessageDialog(null, "First we need your data.");
		
		// Initializing the User creation.
		uCreator.createUser();
		
		// Asking for video loading, answer must be y or n.
		do {
			videoAnswer = JOptionPane.showInputDialog(null, "Would you like to load a video? (y/n)");
			if (videoAnswer.equals("y")) {
				vCreator.createVideo();				
			} else if (videoAnswer.equals("n")) {				
				// Printing the user data.
				JOptionPane.showMessageDialog(null, "SUMMARY:\n" + uCreator.getUser() + "\nVIDEOS: 0");
				System.exit(1);
			} else {
				JOptionPane.showMessageDialog(null,  "You must enter a valid answer (y/n).");
				continue;
			}
		} while (! (videoAnswer.equals("y") || videoAnswer.equals("n")));
		
		// Offering to add more videos. 
		do {
			videoAnswer = JOptionPane.showInputDialog(null, "Would you like to load another video? (y/n)");
			if (videoAnswer.equals("y")) {
				vCreator.createVideo();
				continue;
			} else if (videoAnswer.equals("n")) {
				JOptionPane.showMessageDialog(null, "Thank you.");
				break;
			} else {
				JOptionPane.showMessageDialog(null,  "You must enter a valid answer (y/n).");
				continue;
			}
		} while (! (videoAnswer.equals("n")));
		
		// Printing the user data.
		JOptionPane.showMessageDialog(null, "DATA SUMMARY: \n" + uCreator.getUser());
		
		// Showing videos and status.
		JOptionPane.showMessageDialog(null, "VIDEO SUMMARY: " + vCreator.getVideosSize() 
						+ vCreator.getVideos());		
		
		do {
			playAnswer = JOptionPane.showInputDialog("Would you like to play, pause or stop any video? (y/n):");
			if (playAnswer.equals("y")) {
				vCreator.setChangePlaying();
				JOptionPane.showMessageDialog(null, vCreator.getAllPlayingStates());
				continue;
			}
			else if (playAnswer.equals("n")) {
				JOptionPane.showMessageDialog(null, "Thank you, that will be all.");
				break;
			} else {
				JOptionPane.showMessageDialog(null,  "You must enter a valid answer (y/n).");
				continue;
			}				
		} while (! playAnswer.equals("n"));
		
		// Showing videos and status.
		JOptionPane.showMessageDialog(null, "FINAL VIDEO SUMMARY: " 
				+ vCreator.getVideosSize() + vCreator.getVideos());	
	}

}
