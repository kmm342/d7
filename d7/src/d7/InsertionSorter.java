package d7;

import java.util.Comparator;
import java.util.List;

public class InsertionSorter<E> extends Sorter<E> {

	
	/**
	 * Precondition:
	 *     0            length
	 * a: [     ?      ]
	 * 
	 * Postcondition: a is sorted, (according to cmp)
	 *     0            length
	 * a: [   sorted   ]
	 */
	public void sort(List<E> a) {
		// invariant:    0          i         length
				//           a: [  sorted  |    ?    ]
				
				int i = 0;
				// initialization: a[0..i) is empty, thus sorted.
				
				while (i < a.size()) {
					i ++; // progress: i is increasing
					
					// know:      0            i           length
					//        a: [  sorted  |?|     ?     ]
					
					// inner loop invariant:
					//               0          j                   i        length
					//           a: [  sorted  |?|  sorted > a[j]  |   ?    ]
					
					int j = i - 1;
					// inner loop initiailization: a[j+1..i) is empty, and so is > a[j]
					
					while (!(j == 0 || compare(a,j-1,j) <= 0)) {
						j--; // progress: j decreases
						swap(a,j,j+1);
					}
					
					// after inner loop, want:
					//      0            i           length
					//  a: [   sorted   |     ?     ]
					//
					// termination: if j == 0, then a[0..i) is sorted, since a[0] is smallest and
					// everything else is sorted.
					// if a[j-1] <= a[j] then a[0..i) is a[0..j-1, j, j+1..i) and
					//   a[0] <= a[1] <= .. <= a[j-1] by invariant
					//   a[j-1] <= a[j] by loop termination
					//   a[j] < a[j+1] <= a[j+1] <= ... <= a[i-1] by invariant
					// so a[0...i) is sorted.
				}
				// termination: length == i so a[0..length) is a[0..i) which is sorted
	}
	
	
	public InsertionSorter(Comparator<E> cmp) {
		super(cmp);
		// TODO Auto-generated constructor stub
	}
	
	public static class Tests extends Sorter.Tests  {

		@Override
		Sorter<Integer> sorter() {
			return new InsertionSorter<Integer>(Comparator.naturalOrder());
			// TODO Auto-generated method stub

		}
		
	}

	public static void main(String[] args) {


	}
	

	
	public void InsertionSorter(List<E> a) {
		// TODO Auto-generated method stub
	}

}
