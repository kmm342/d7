import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import 

class rectangleTester {

	@Test
	//test Constructor 1
	void test() {
		Rectangle r = new Rectangle(3,5);
		assertEquals(3, r.getLength());
		assertEquals(5, r.getWidth());
		fail("Not yet implemented");		
	}
	
	@Test
	//test Constructor 1 (negative width)
	void test1() {
		assertThrows(AssertionError.class, ()->{new Rectangle(-3,5);});
	}
	
	
	@Test
	//test Constructor 2
	void test2() {
		Rectangle r2 = new Rectangle(4);
		assertEquals(4, r2.getLength());
		assertEquals(null, r2.getWidth());
		
	}
	
	@Test
	//test Constructor 2 (negative width)
	void test3() {
		Rectangle r2 = new Rectangle(-4);
		assertThrows(AssertionError.class, ()->{new Rectangle(null)});
	}
	
	@Test
	//test Setter Width
	void test4() {
		
	}

}
