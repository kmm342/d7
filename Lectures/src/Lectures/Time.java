package Lectures;

public class Time implements Lectures.TimeInterface {
	//Class Invariant: in range [0..60*24]
	//class invariant: minutesSinceMidnight == 60*hour + minutes
	private int minutesSinceMidnight;
	
	//wrong! don't start here!; you want it to be general-->specific
//	int hour;
//	int minute;
	/** return the minute within the hour, in range [0..60)-->0 is included, 60 is not
	 * @return
	 */
	private int minute;
	
	private int hour;
	
	/**initialize this to represent the hour h and minute*
	 * @param m the minutes, in [0..60)
	 * @param h the hour, in [0..24)*/
	public Time(int m, int h) {
		assert m >= 0 && m < 60;
		assert h >= 0 && h < 24;
		this.hour = h;
		this.minute = m;
		this.minutesSinceMidnight = h*60 + m;
	}
	//this is the default:
	//public Time() {}
	//overloading: two methods with same name, different arg types
	//if same name, same arg types-->not allowed, will return error b/c Java 
	//can't distinguish
	public Time() {
		this.hour = 12;
		this.minute = 0; 
		this.minutesSinceMidnight = 60*12;
	}
	
	public int minute() {
//		return 0; not good; don't return default message; it will look like it's implemented when it's not
		//return minute; //could also write this.minute; same thing.
		//throw new NotImplementedError();
		return minutesSinceMidnight % 60;
	}
	
	/**return the hour, in [9..24)*/
	public int hour() {
		//return this.hour; 
		//throw new NotImplementedError();
		return this.minutesSinceMidnight / 60;
		
	}

	/**update this object changing the minute to m
	 * 5
	 * @param m the new minutes, in range [0..60) //precondition
	 */
	public void setMinute(int m) {
		assert minute >= 0 && minute < 60;
		this.minute = minute;
		this.minutesSinceMidnight = 60*this.hour() + minute;
//		throw new NotImplementedError();
	}
	
	/** update this object, changing the hour to h
	 * 
	 * @param h the new hour, in range [0..24)
	 */
	public void setHour(int h) {
		assert h >= 0 && h < 24;
		this.hour = h;
		this.minutesSinceMidnight = this.minute() + 60*h;
		//this.hour = h;
//		throw new NotImplementedError();
	}
}
