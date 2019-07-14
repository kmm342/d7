package Lectures;

import java.time.LocalTime;

import Lectures.NotImplementedError;

public class ClockTime {
	
	@Override
	public int hour() {
		return LocalTime.now().getHour();
	}
	
	@Override
	public int minute() {
		return LocalTime.now().getMinute();
	}
}
