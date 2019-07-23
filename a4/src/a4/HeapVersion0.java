package a4;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class HeapVersion0<E, P> implements PriorityQueue<E, P> {

	//create array to store elements of type Item
	private int size;
	private Item[] b = (Item[]) Array.newInstance(Item.class, size);
	
	//create HashMap containing (Item object, Array Index)
	private HashMap<E, Integer> map = new HashMap<>();
	
	//set up Class Item and constructor for elements in Heap//
	private class Item {
		private E value;
		private double priority;
			
		//Item object constructor
		public Item(E value, double priority) {
			this.value = value; 
			this.priority = priority;
		}
	}
	
	
	@Override
	public Comparator<? super P> comparator() {
		
		//compare the priorities and return +1,-1,0 if first element is 
		//greater than, less than, or equal to the second element
		compare(T o1, T o2);
		
		this.comparator() {
			compare(T o1, T o2);
		}
//		 .compare(Item o1, Item o2) {
//			
//		}
		
		//indicates whether some object is equal to this object 
		boolean equals(Item o1) {		
		}
		
		return null;
	}
	
	@Override
	public int size() {
		return this.size();
	}

//---------------------------------------------------//
	//parent and children nodes:
	
	// Returns the index of 
	// the parent node 
	private Heap<E, P>.Item parent(int i) 
	{ 
	    return b[(i - 1) / 2];    
	} 

	// Returns the index of 
	// the left child node 
	private Heap<E, P>.Item leftChild(int i) 
	{ 
	    return b[2*i+1];
	} 
	
	// Returns the index of 
	// the right child node 
	private Heap<E,P>.Item rightChild(int i) 
	{ 
	    return b[2*i+2];
	} 
//------------------------------------------//	
	
	@Override
	//Remove and return largest element according to Comparator()
	
	//Plan:
		//Take node: while != null ==> 
				//compare to value.leftChild
				//compare to value.rightChild
		//-recursive until null
	public E poll() throws NoSuchElementException {
		// TODO Auto-generated method stub
		int i = 0;
		while (b[i] != null) {
			compareTo(b[i].value, leftChild(i));
			compareTo(b[i].value, rightChild(i));
		}
		
	
		b[i].rightChild.compare();
		
		return null;
	}

	@Override
	public E peek() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	
}
