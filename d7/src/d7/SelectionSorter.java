package d7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SelectionSorter<E> extends Sorter<E>{
	
	public void sort(List<E> a) {
			// invariant:     0                           i         length
			//            a: [ sorted, smaller then rest |    ?    ]
			
			int i = 0;
			// initialization: a[0..0) is empty, thus sorted
			
			while (i < a.size()) {
				i++; // progress: i increases
				int k = indexOfMin(a,i-1,a.size());
				swap(a,i-1,k);
				// preservation: a[i-1] was originally the minimum value of a[i-1...length)
				// so it is smaller than all the rest.
				}
			// termination: i == length, so a[0..length) is a[0..i) which is sorted
			}
	
	/** returns index of the smallest value of a[start...end) */
	private int indexOfMin(List<E> a, int start, int end) {
		// invariant:     start       min           i         end
		//            a: [    >= x   | x |   >= x  |    ?    ]
		
		int min = start, i = start+1;
		// initialization: a[start..min) and a[min+1..i) are empty
		
		while (i < end) {
			i++; // progress: i increasing
			
			//     start    min            i      end
			// a: [  >= x  | x |  >= x  |?|   ?  ]
			if (compare(a,i-1,min) < 0)
				min = i-1;
			
			// preservation: know that a[i-1] >= a[min]
		}
		// termination: i == end, so a[start..i) is a[start..end), and all
		// values are >= x
		return min;
	}

	public SelectionSorter(Comparator<E> cmp) {
		super(cmp);
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub

	}
	
	public static class Tests extends Sorter.Tests  {

		@Override
		Sorter<Integer> sorter() {
			return new SelectionSorter<Integer>(Comparator.naturalOrder());
			// TODO Auto-generated method stub

		}

		@Test
		public void testIndexOfMin() {
			Sorter<Integer> s = sorter();
			List<Integer>    a = testCase();
			
			assertEquals(0, a.get(((SelectionSorter<Integer>) s).indexOfMin(a, 0, a.size())));
			assertEquals(3, a.get(((SelectionSorter<Integer>) s).indexOfMin(a, 2, 5)));
		}
			
	}
	
	public void SelectionSorter(List<E> a) {
		// TODO Auto-generated method stub
	}

}


