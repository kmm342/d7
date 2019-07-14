package a1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

class ExercisesTest {

	@Test
	void testNormalize() {
		assertEquals("hannah", Exercises.normalize("han@nah"));
		assertEquals("hannah", Exercises.normalize("han nah"));
		assertEquals("hannah", Exercises.normalize("%han@nah#"));
		assertEquals("hannah", Exercises.normalize(" han  nah "));
		assertEquals("hannah", Exercises.normalize("$h an@n ah"));
		assertEquals("hannah", Exercises.normalize("hannah"));
	}
	
	@Test
	void testMedian() {
		int[] a1 = new int[3];
		for(int i = 0; i < a1.length; i ++)
			a1[i] = 1;
		assertEquals(1, Exercises.median(a1));
		int[] a2 = new int[3];
		for(int j = 0; j < a2.length; j++)
			a2[j] = j;
		assertEquals(1, Exercises.median(a2));
		int[] a3 = new int[4];
		for(int k = 0; k < a3.length; k++)
			a3[k] = k;
		assertEquals(1, Exercises.median(a3));
		int[] a4 = new int[0];
		assertThrows(AssertionError.class, () -> {Exercises.median(a4);}); 
	}
	
	@Test
	void testNumZeroes() {
		int[] a1 = new int[3];
		assertEquals(3, Exercises.numZeroes(a1));
		int[] a2 = new int[3];
		a2[1] = 1;
		assertEquals(2, Exercises.numZeroes(a2));
		int[] a3 = new int[4];
		for(int k = 0; k < a3.length; k++)
			a3[k] = 1;
		assertEquals(0, Exercises.numZeroes(a3));
		int[] a4 = new int[0];
		assertEquals(0, Exercises.numZeroes(a4)); 
	}
	
	@Test
	void testMean() {
		int[] a1 = new int[3];
		for(int i = 0; i < a1.length; i ++)
			a1[i] = 1;
		assertEquals(1, Exercises.mean(a1));
		int[] a2 = new int[3];
		for(int j = 3; j < a2.length + 3; j++)
			a2[j - 3] = j;
		assertEquals(4, Exercises.mean(a2));
		int[] a3 = new int[4];
		for(int k = 0; k < a3.length; k++)
			a3[k] = k;
		assertEquals(1.5, Exercises.mean(a3));
		int[] a4 = new int[0];
		assertThrows(AssertionError.class, () -> {Exercises.median(a4);});
	}
	
	@Test
	void testHasConstDiagonal() {
		int[][] a1 = new int[0][0];
		int[][] a2 = new int[1][1];
		int[][] a3 = new int[3][3];
		int[][] a4 = new int[3][3];
		int[][] a5 = new int[3][4];
		a3[1][1] = 1;
		assertTrue(Exercises.hasConstDiagonal(a2));
		assertFalse(Exercises.hasConstDiagonal(a3));
		assertTrue(Exercises.hasConstDiagonal(a4));
		assertThrows(AssertionError.class, () -> {Exercises.hasConstDiagonal(a1);});
		assertThrows(AssertionError.class, () -> {Exercises.hasConstDiagonal(a5);});
	}
}

