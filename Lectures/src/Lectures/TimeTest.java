package Lectures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeTest {

	@Test
	void test() {
		Time t = new Time(3,17);
		//t.setMinute(17);;
		//check t.getMinute is 17
		assertEquals(t.minute(),17);
		fail("Not yet implemented");
		
		//t.setHour(3);
		assertEquals(t.hour(),3);
	}
	
}
