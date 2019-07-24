package d7;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Comparator;

	
	
	public abstract class Sorter<E> {
		
		////////////////////////////////////////////////////////////////////////////
		// comparator handling wrappers ////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////
		
		
		private Comparator<E> cmp;
		
		public Sorter(Comparator<E> cmp) {
			this.cmp = cmp;
		}
		
		/**
		 * Precondition:
		 *     0            length
		 * a: [     ?      ]
		 * 
		 * Postcondition: a is sorted, (according to cmp)
		 *     0            length
		 * a: [   sorted   ]
		 */
		public abstract void sort(List<E> a);
		
		/** exchange a[i] and a[j] */
		protected void swap(List<E> a, int i, int j) {
			E tmp = a.get(i);
			a.set(i, a.get(j));
			a.set(j, tmp);
		}
		
		/**
		 * Compare a[i] and a[j].
		 * Return < 0 if a[i] < a[j]; return = 0 if a[i] = a[j] and return
		 * >0 if a[i] > a[j]
		 */
		protected int compare(List<E> a, int i, int j) {
			return this.cmp.compare(a.get(i), a.get(j));
		}
		
		////////////////////////////////////////////////////////////////////////////
		// Insertion sort                                                         //
		////////////////////////////////////////////////////////////////////////////
		


		////////////////////////////////////////////////////////////////////////////
		// Selection sort //////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////
		
		


		////////////////////////////////////////////////////////////////////////////
		// Merge sort //////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////
		
		/** sort a[start..end) and leave rest of a alone
		 * post condition:
		 *            start         end
		 * a: [      | sorted      |      ]
		 * 
		 * @param a
		 * @param start
		 * @param end
		 */
		public void mergeSort(List<E> a, int start, int end) {
			if (end - start <= 1)
				return;
			
			int mid = (end + start)/2;
			
			mergeSort(a,start,mid);
			mergeSort(a,mid,end);
			
			//          start       mid        end
			// a: [    |  sorted   |  sorted  |     ]
			
			merge(a, start, mid, end);
		}
		
		/**
		 * Precondition:         start      mid        end
		 *               a: [   |  sorted  |  sorted  |       ]
		 *               
		 * Postcondition:        start                 end
		 *               a: [   |     sorted          |       ]
		 * 
		 */
		private void merge(List<E> a, int start, int mid, int end) {
			List<E> result = new ArrayList<E>();
			
			// invariant: result is sorted
			//            start       i                   mid          j                    end
			//   a:  [   | in result | sorted, >= result | in result  |  sorted, >= result |     ] 
			
			int i = start; int j = mid;
			
			while (i != mid || j != end) {
				if (i == mid) {
					result.add(a.get(j));
					j++;
				}
				else if (j == end) {
					result.add(a.get(i));
					i++;
				}
				else if (compare(a,i,j) < 0) {
					result.add(a.get(i));
					i++;
				}
				else {
					result.add(a.get(j));
					j++;
				}
			}
			
			// a: [   |  in result   |  in result  |   ]
			
			// copy result back into a
			for(int k = 0; k < result.size(); k++) {
				a.set(start+k, result.get(k));
			}
		}
		
		////////////////////////////////////////////////////////////////////////////
		// Tests ///////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////
		
		public static abstract class Tests {
			
			abstract Sorter<Integer> sorter();
			
			protected static List<Integer> testCase() {
				//                   0 1 2 3 4 5 6 7 8
				return Arrays.asList(1,0,7,3,5,4,9,2,0);
			}
			
			private static List<Integer> testCaseSorted() {
				List<Integer> result = testCase();
				result.sort(Comparator.naturalOrder());
				return result;
			}
			
			@Test
			public void testSwap() {
				Sorter<Integer> s = sorter();
				List<Integer>    a = testCase();
				
				s.swap(a,1,2);
				assertEquals(7,a.get(1));
				assertEquals(0,a.get(2));
			}
			
			@Test
			public void testCompare() {
				Sorter<Integer> s = sorter();
				List<Integer>    a = testCase();

				assertTrue(s.compare(a,0,1) > 0);
				assertTrue(s.compare(a, 1, 8) == 0);
				assertTrue(s.compare(a, 1, 0) < 0);
			}
			
			@Test
			public void testSort() {
				Sorter<Integer> s = sorter();
				List<Integer>    a = testCase();
				s.sort(a);
				assertEquals(testCaseSorted(), a);
			}
			
			@Test
			public void testMerge() {
				Sorter<Integer> s = sorter();
				//                                 0 1 2  3 4 5 6 7  8 9
				//                                [      |     |    |   ]
				List<Integer>    a = Arrays.asList(1,0,7 ,3,6,8,2,7 ,0,7);
				List<Integer>  exp = Arrays.asList(1,0,7 ,2,3,6,7,8 ,0,7);
				s.merge(a, 3, 6, 8);
				assertEquals(exp,a);
			}
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
	
	
