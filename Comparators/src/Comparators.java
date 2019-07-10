import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Comparators {
	// Number interfaces ///////////////////////////////////////////////////////
	
	public static interface Num {
		public double toDouble();
	}
	
	public static class Int implements Num {
		public int i;
		public Int(int i)    { this.i = i; }
		public double toDouble() { return this.i; }
		public String toString() { return String.valueOf(this.i); }
		public boolean equals(Object other) { return other instanceof Int && this.i == ((Int) other).i; }
	}

	public static class Doub implements Num {
		double d;
		public Doub(double d)  { this.d = d; }
		public double toDouble() { return this.d; }
		public String toString() { return String.valueOf(this.d); }
		public boolean equals(Object other) { return other instanceof Doub && this.d == ((Doub) other).d; }
	}

	/** Return the given values as Integer objects; for testing. */
	public static Int[] makeIntTest(int[] values) {
		Int[] ints = new Int[values.length];
		for (int i = 0; i < values.length; i++) {
			ints[i] = new Int(values[i]);
		}
		return ints;
	}
	
	/** Return the given values as Double objects, for testing. */
	public static Doub[] makeDoubleTest(double[] values) {
		Doub[] result = new Doub[values.length];
		for (int i = 0; i < values.length; i++) {
			result[i] = new Doub(values[i]);
		}
		return result;
	}
	
	// Comparator examples /////////////////////////////////////////////////////
	
	public static class NumberComparator implements Comparator<Num> {
		/**
		 * Compare n1 and n2 using toDouble.
		 * @see java.util.Comparator#compare
		 */
		@Override
		public int compare(Num n1, Num n2) {
			// TODO: DONE
			int n = 0;
			try {
			if (n1.toDouble() < n2.toDouble()) {
				n = -1;
			}
			if (n1.toDouble() == n2.toDouble()) {
				n = 0;
			}
			if (n1.toDouble() > n2.toDouble()) {
				n = 1;
			}
			//return n;
			}
			catch (NullPointerException e) {
				System.err.println("Null Comparison between n1, n2" + e.getMessage());
			}
			return n;
		}
		
	}
	
	@Test
	public void testNumberComparator() {
		Int[] ia     = makeIntTest(new int[] {4,1,2,0,3});
		Int[] sorted = makeIntTest(new int[] {0,1,2,3,4});
		Arrays.sort(ia, new NumberComparator());
		assertArrayEquals(ia, sorted);
	}
	
	public static class IntegerComparator implements Comparator<Int> {
		/**
		 * Compare i1 and i2 according to their i fields.
		 * @see java.util.Comparator#compare
		 */
		@Override
		public int compare(Int n1, Int n2) {
			// TODO: DONE
			int n = 0;
			try {
			if  (n1.i < n2.i) {
				n = -1;
			}
			if (n1.i == n2.i) {
				n = 0;
			}
			if (n1.i > n2.i) {
				n = 1;
			}
			}
			catch (NullPointerException e) {
				System.err.println("Null Comparison between n1, n2" + e.getMessage());
			}
			return n;
		}
	}
	
	@Test
	void testIntegerComparator() {
		Int[] ia     = makeIntTest(new int[] {4,1,2,0,3});
		Int[] sorted = makeIntTest(new int[] {0,1,2,3,4});
		Arrays.sort(ia, new IntegerComparator());
		assertArrayEquals(ia, sorted);	
	}

	// Generic comparators /////////////////////////////////////////////////////
	
	/**
	 * A ReverseComparator stores a reference to another comparator, and
	 * sorts values in the opposite order.
	 */
	public static class ReverseComparator<T> implements Comparator<T>  {
		private Comparator<T> forwardComparator;
		
		public ReverseComparator(Comparator<T> forwardComparator) {
			this.forwardComparator = forwardComparator;
		}
		
		@Override
		public int compare(T arg0, T arg1) {
			// TODO: DONE???

			return forwardComparator.compare(arg1, arg0);

		}
		
	}
	
	@Test
	public void testReverseComparator() {
		Int[] ia     = makeIntTest(new int[] {4,1,2,0,3});
		Int[] sorted = makeIntTest(new int[] {4,3,2,1,0});
		Arrays.sort(ia, new ReverseComparator<Num>(new NumberComparator()));
		assertArrayEquals(ia, sorted);
	}
	
	// Merge ///////////////////////////////////////////////////////////////////
	
	/**
	 * Add the sorted outputs produced by in1 and in2 into result, in increasing
	 * order (according to c).
	 * 
	 * @param in1 outputs items in increasing order (according to c)
	 * @param in2 outputs items in increasing order (according to c)
	 */
	// NOTE: the <T> here is a "type parameter", it can be automatically filled
	// in with any type.
	public static <T> void merge(List<? super T> result, Iterator<? extends T> in1, Iterator<? extends T> in2, Comparator<? super T> c) {
		// TODO
		
		
		T in1element = in1.next();
		T in2element = in2.next();
		
	
		while (in1.hasNext() || in2.hasNext()) {
			if (c.compare(in1element, in2element) == 1) {
				result.add(in2element);
				
				in2element = in2.next();
			}
			
			if (c.compare(in1element, in2element) == 0) {
				result.add(in1element);
				result.add(in2element);
				
				in1element = in1.next();
				in2element = in2.next();
			}
			
			else 
			{//in1element < in2element
				result.add(in1element);
				
				in1element = in1.next();
			}

		}

}

	
	
	@Test
	public void testMerge() {
		List<Int> in1 = Arrays.asList(makeIntTest(new int[] {1, 2, 4, 5, 7}));
		List<Int> in2 = Arrays.asList(makeIntTest(new int[] {0, 3, 6}));
		
		List<Int> result = new ArrayList<Int>();
		List<Int> expect = Arrays.asList(makeIntTest(new int[] {0,1,2,3,4,5,6,7}));
		merge(result, in1.iterator(), in2.iterator(), new IntegerComparator());
		assertEquals(expect, result);
	}
}
