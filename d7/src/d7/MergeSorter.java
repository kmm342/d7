package d7;

import java.util.Comparator;
import java.util.List;

public class MergeSorter<E> extends Sorter<E> {

	
	
	public void sort(List<E> a) {
		mergeSort(a,0,a.size());
	}
	
	
	public MergeSorter(Comparator<E> cmp) {
		super(cmp);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	}

	public static class Tests extends Sorter.Tests {

		@Override
		Sorter<Integer> sorter() {
			// TODO Auto-generated method stub
			return new MergeSorter<Integer>(Comparator.naturalOrder());
		}
	}
	
	public void MergeSorter(List<E> a) {
		// TODO Auto-generated method stub
	}
		
}
