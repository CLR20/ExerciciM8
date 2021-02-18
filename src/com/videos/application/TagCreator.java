package com.videos.application;

import com.videos.domain.*;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;


public class TagCreator {
	
	private static Videos video;
	private static String tag;
	
	public TagCreator () {
	}
	
	public void createTag (Videos video) {
		
		this.video = video;
		String tagAnswer;
		
		// Adding at least one tag.		
		do {
			tag = JOptionPane.showInputDialog("Enter a tag for the video:");
			
			// Checking that tag is not null.
			try {
				checkData(tag);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "ERROR FOUND. You must enter at least one tag."
						+ "\nException type: " + e.getClass().getName());
			}			
			video.addTag(tag);
			
		} while (tag.length() < 1);
		
		// Offering to add extra tags.
		do {
			tagAnswer = JOptionPane.showInputDialog("Would you like to add another tag? (y/n)");
			if (tagAnswer.equals("y")) {
				tag = JOptionPane.showInputDialog("Enter a tag for the video:");
				video.addTag(tag);
			} else if (tagAnswer.equals("n")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "You must enter a valid answer.");
			}
		} while (! tagAnswer.equals("n"));
	}
	
	// Method to check that tags has at list one field.
	static void checkData (String tag) throws NullPointerException {
		if (tag.length() < 1) {
			throw new NullPointerException ();
		}
	}
	

}
