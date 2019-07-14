package b1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {
	
	/**BlockA Testing*/
	@Test
	void test1A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.name(), "Anthony" );
	}
	
	@Test 
	void test2A() {
		Person p = new Person(null, 1975, 1, 5);
		assertEquals(p.name(), null );
		//Person.java should crash bc of failed assert statement
	}

	@Test
	void test3A() {
		Person p = new Person("", 1975, 1, 5);
		assertEquals(p.name(), "");
		//Person.java should crash bc of failed assert statement 
	}
	
	@Test
	void test4A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.mother(), null);
	}
	
	@Test
	void test5A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.father(), null);
	}

	@Test
	void test6A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.birthYear(), 1975);
	}
	
	@Test
	void test7A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.birthMonth(), 1);
	}
	
	@Test
	void test8A() {
		Person p = new Person("Anthony", 1975, -1, 5);
		assertEquals(p.birthMonth(), -1);
		//Person.java should crash bc of failed assert statement 
	}
	
	@Test
	void test9A() {
		Person p = new Person("Anthony", 1975, 13, 5);
		assertEquals(p.birthMonth(), 13);
		//Person.java should crash bc of failed assert statement
	}
	
	@Test
	void test10A() {
		Person p = new Person("Anthony", 1975, 13, 5);
		assertEquals(p.birthDay(), 5);
	}
	
	@Test
	void test11A() {
		Person p = new Person("Anthony", 1975, 13, -1);
		assertEquals(p.birthDay(), -1);
	}
	
	@Test
	void test12A() {
		Person p = new Person("Anthony", 1975, 13, 32);
		assertEquals(p.birthDay(), 32);
	}
	
	@Test
	void testA10() {
		Person p1 = new Person("Alex", 1978, 1, 1);
		Person father1 = new Person("Anthony", 1938, 1, 6);
		Person father2 = new Person("James", 1936, 2, 11);
		
		p1.setFather(father1);
		assertEquals(1, father1.numChildren());
		
		p1.setFather(father2);
		assertEquals(1, father2.numChildren());
		assertEquals(0, father1.numChildren());
	}
	
	
	/**Block B Testing*/
	
	@Test
	void testB1() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setName("Bob");
		assertEquals(p.name(), "Bob");
	}
	
	@Test
	void testB2() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setName(null);
		assertEquals(p.name(), null);
	}
	
	@Test
	void testB3() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setName("");
		assertEquals(p.name(), "");
	}
	
	@Test
	void testB4() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthYear(1998);
		assertEquals(p.birthYear(), 1998);
	}
	
	@Test
	void testB5() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthMonth(2);
		assertEquals(p.birthMonth(), 2);
	}
	
	@Test
	void testB6() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthMonth(-1);
		assertEquals(p.birthMonth(), -1);
	} 
	
	@Test
	void testB7() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthMonth(13);
		assertEquals(p.birthMonth(), 13);
	}
	
	@Test
	void testB8() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthDay(9);
		assertEquals(p.birthDay(), 9);
	}
	
	@Test
	void testB9() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthDay(-1);
		assertEquals(p.birthDay(), -1);
	}
	
	@Test
	void testB10() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthDay(32);
		assertEquals(p.birthDay(), 32);
	}
	
	@Test
	void testB11() {
		Person p = new Person("Anthony", 1975, 1, 5);
		Person a = new Person("Mom", 1936, 1, 5);
		p.setMother(a);
		assertEquals(p.mother(), a);
	}
	
	@Test
	void testB12() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setMother(null);
		assertEquals(p.mother(), null);
	}
	
	@Test
	void testB13() {
		Person p = new Person("Anthony", 1975, 1, 5);
		Person a = new Person("Dad", 1936, 1, 5);
		p.setFather(a);
		assertEquals(p.father(), a);
	}
	
	@Test
	void testB14() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setFather(null);
		assertEquals(p.father(), null);
	}	
	
	/**Block C: Testing*/
	
	@Test
	void testC1() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1975, 1, 6);
		
		Person mom = new Person("Alice", 1932, 1, 7);
		Person dad = new Person("Jack", 1936, 1, 15);
		
		p1.setMother(mom);
		p2.setMother(mom);
		
		p1.setFather(dad);
		p2.setFather(dad);
		
		assertEquals(p1.isHalfSibling(p2), false);
	}
	
	@Test
	void testC2() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1975, 1, 6);
		
		Person mom = new Person("Alice", 1932, 1, 7);
		Person dad = new Person("Jack", 1936, 1, 15);
		Person dad2 = new Person("Jordan", 1939, 1, 16);
		
		p1.setMother(mom);
		p2.setMother(mom);
		
		p1.setFather(dad);
		p2.setFather(dad2);

		assertEquals(p1.isHalfSibling(p2), true);
	}
	
	@Test
	void testC3() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1975, 1, 6);
		
		Person mom = new Person("Alice", 1932, 1, 7);
		Person mom2 = new Person("Allison", 1931, 1, 8);
		
		Person dad = new Person("Jack", 1936, 1, 15);
		
		p1.setMother(mom);
		p2.setMother(mom2);
		
		p1.setFather(dad);
		p2.setFather(dad);

		assertEquals(p1.isHalfSibling(p2), true);
	}
	
	
	
	@Test
	void testC4() {
		Person p1 = new Person("Alex", 1975, 1, 6);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p1.isOlderThan(p2), true);
	}
	
	@Test
	void testC5() {
		Person p1 = new Person("Alex", 1975, 1, 6);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p2.isOlderThan(p1), false);
	}
	
	@Test
	void testC6() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1978, 3, 6);
		assertEquals(p1.isOlderThan(p2), true);
	}
	
	@Test
	void testC7() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1978, 3, 6);
		assertEquals(p2.isOlderThan(p1), false);
	}
	
	@Test
	void testC8() {
		Person p1 = new Person("Alex", 1978, 1, 1);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p1.isOlderThan(p2), true);
	}
	
	@Test
	void testC9() {
		Person p1 = new Person("Alex", 1978, 1, 1);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p2.isOlderThan(p1), false);
	}
	
}
