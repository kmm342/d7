package a1;

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
		assertEquals(p.name(), null);
		//Person.java should crash bc of failed assert statement
	}

	@Test
	void test3A() {
		Person p = new Person("", 1975, 1, 5);
		assertEquals(p.name(), "");
		//Person.java should crash bc of failed assert statement 
	}
	
	@Test
	//test4A: see if mother() returns null when mother unknown
	void test4A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.mother(), null);
	}
	
	@Test
	//test5A: see if father() returns null when unknown
	void test5A() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.father(), null);
	}

	@Test
	//test8: see if birthYear() returns birth year (using Constructor)
	void test8() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.birthYear(), 1975);
	}
	
	@Test
	//test9: see if birthMonth() returns birth month (using Constructor)
	void test9() {
		Person p = new Person("Anthony", 1975, 1, 5);
		assertEquals(p.birthMonth(), 1);
	}
	
	@Test
	//test10: see what happens when Constructor sets birthMonth <1
	void test10() {
		Person p = new Person("Anthony", 1975, -1, 5);
		assertEquals(p.birthMonth(), -1);
		//Person.java should crash bc of failed assert statement 
	}
	
	@Test
	//test11: see what happens when Constructor sets birthMonth >12
	void test11() {
		Person p = new Person("Anthony", 1975, 13, 5);
		assertEquals(p.birthMonth(), 13);
		//Person.java should crash bc of failed assert statement
	}
	
	@Test
	//test12: see if birthDay() returns birth day (using Constructor)
	void test12() {
		Person p = new Person("Anthony", 1975, 13, 5);
		assertEquals(p.birthDay(), 5);
	}
	
	@Test
	//test13: see what happens when birth day <1
	void test13() {
		Person p = new Person("Anthony", 1975, 13, -1);
		assertEquals(p.birthDay(), -1);
	}
	
	@Test
	//test14: see what happens when birth day>31
	void test14() {
		Person p = new Person("Anthony", 1975, 13, 32);
		assertEquals(p.birthDay(), 32);
	}
	
	/**Block B Testing*/
	
	@Test
	//test setName with regular string
	void testB1() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setName("Bob");
		assertEquals(p.name(), "Bob");
	}
	
	@Test
	//test setName with null --> should crash
	void testB2() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setName(null);
		assertEquals(p.name(), null);
	}
	
	@Test
	//test setName with "" --> should crash
	void testB3() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setName("");
		assertEquals(p.name(), "");
	}
	
	@Test
	//test setBirthYear to integer
	void testB4() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthYear(1998);
		assertEquals(p.birthYear(), 1998);
	}
	
	@Test
	//test setBirthMonth to integer
	void testB5() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthMonth(2);
		assertEquals(p.birthMonth(), 2);
	}
	
	@Test
	//test setBirthMonth to <1 --> code should crash bc of failed assert
	void testB6() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthMonth(-1);
		assertEquals(p.birthMonth(), -1);
	} 
	
	@Test
	//test setBirthMonth to >12 --> code should crash bc of failed assert
	void testB7() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthMonth(13);
		assertEquals(p.birthMonth(), 13);
	}
	
	//test setBirthDay 
	void testB8() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthDay(9);
		assertEquals(p.birthDay(), 9);
	}
	
	//test setBirthDay to <1 --> code should crash bc of failed assert
	void testB9() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthDay(-1);
		assertEquals(p.birthDay(), -1);
	}
	
	//test setBirthDay to >31 --> code should crash bc of failed assert
	void testB10() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setBirthDay(32);
		assertEquals(p.birthDay(), 32);
	}
	
	//test setMother and see if it returns proper mother
	void testB11() {
		Person p = new Person("Anthony", 1975, 1, 5);
		Person a = new Person("Mom", 1936, 1, 5);
		p.setMother(a);
		assertEquals(p.mother(), a);
	}
	
	@Test
	//test setMother with null--> should return null
	void testB12() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setMother(null);
		assertEquals(p.mother(), null);
	}
	
	@Test
	//test7: test setFather and see if it returns proper father
	void testB13() {
		Person p = new Person("Anthony", 1975, 1, 5);
		Person a = new Person("Dad", 1936, 1, 5);
		p.setFather(a);
		assertEquals(p.father(), a);
	}
	
	@Test
	//test setFather with null--> should return null
	void testB14() {
		Person p = new Person("Anthony", 1975, 1, 5);
		p.setFather(null);
		assertEquals(p.father(), null);
	}	
	
	/**Block C: Testing*/
	
	@Test
	//test isHalfSibling: set both their moms and their dads to be the same
		//should return False bc they're not half-siblings
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
	//test isHalfSibling: set their moms to be same, but different dads
		//should return True bc they're half siblings
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
	//test isHalfSibling: set their dads to be same, but different moms
		//should return True bc they're half siblings
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
	//test isOlderThan: they have different Birth Years
		//Should return true bc p1 will be set to have earlier Birth Year
	void testC4() {
		Person p1 = new Person("Alex", 1975, 1, 6);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p1.isOlderThan(p2), true);
	}
	
	@Test
	//test isOlderThan: they have different Birth Years, but now switch p1, p2
		//Should return false bc p2 has later Birth Year
	void testC5() {
		Person p1 = new Person("Alex", 1975, 1, 6);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p2.isOlderThan(p1), false);
	}
	
	@Test
	//test isOlderThan: they have same Birth Years, but Different Birth Months
		//Should return true bc p1 will be set to have earlier Birth Month
	void testC6() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1978, 3, 6);
		assertEquals(p1.isOlderThan(p2), true);
	}
	
	@Test
	//test isOlderThan: they have same Birth Years, but Different Birth Months
		//but now switch p1, p2
	//Should return false bc p2 has later Birth Month
	void testC7() {
		Person p1 = new Person("Alex", 1978, 1, 6);
		Person p2 = new Person("Anthony", 1978, 3, 6);
		assertEquals(p2.isOlderThan(p1), false);
	}
	
	@Test
	//test isOlderThan: they have same Birth Years, same Birth Months, 
	//but different Birth Day
		//Should return true bc p1 has earlier Birth Day
	void testC8() {
		Person p1 = new Person("Alex", 1978, 1, 1);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p1.isOlderThan(p2), true);
	}
	
	@Test
	//test isOlderThan: they have same Birth Years, same Birth Months, 
	//but different Birth Day; but now switch p1, p2
		//Should return true bc p2 has later Birth Day
	void testC9() {
		Person p1 = new Person("Alex", 1978, 1, 1);
		Person p2 = new Person("Anthony", 1978, 1, 6);
		assertEquals(p2.isOlderThan(p1), false);
	}
	
//Test Father:
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
	
	
	
}
