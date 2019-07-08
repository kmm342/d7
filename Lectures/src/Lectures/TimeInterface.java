package Lectures;
//He named the Interface: Time and placed it in different package he created, Lecture 4
//He also renamed Time.Java to TimeDemo.java
public interface TimeInterface {
	/** returns the hour represented by this, in range [0..24) */
	int hour();
	
	/** returns the minute within the hours, in range [0..60) */
	int minute();
}
