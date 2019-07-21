package a4;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Heap<E, P> implements PriorityQueue<E, P> {

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
		//still working 
		
		return null;
	}

	@Override
	public int size() {
		return this.size();
	}

	@Override
	public E poll() throws NoSuchElementException {
		// TODO Auto-generated method stub
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
