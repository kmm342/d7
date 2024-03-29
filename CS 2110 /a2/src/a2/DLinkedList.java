package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * An instance is a doubly linked list. It provides much of the functionality
 * of Java class java.util.LinkedList.
 */
public class DLinkedList<E> extends java.util.AbstractList<E> {
    /** Number of nodes in the linked list. */
    private int size;

    /** first node of the linked list (null if the list is empty) */
    private Node head;

    /** last  node of the linked list (null if the list is empty) */
    private Node tail;
    
    /** Constructor: an empty linked list. */
    public DLinkedList() {
        // TODO item #1
        // Look at the class invariant to determine how to implement this.  
    	/** Empty Linked List: no existing nodes; pointer to first+last nodes 
    	 * are both null; size will be 0
    	 */
    	head = null;
    	tail = null;
    	size = 0;
    }

    /**
     * Return the number of elements in this list.
     * This operation must take constant time.
     */
    public @Override int size() {
        // TODO item #2
        // This is an extremely small method
    	/**Return the size of this list*/
    	return size;   		
    }

    /**
     * Return "[s0, s1, .., sn]" where (s0, s1, .., sn) are strings representing
     * the objects contained in this, in order.  Uses toString to convert the
     * objects to strings.
     *
     * For example, if this contains 6 3 8 in that order, the result is "[6, 3, 8]".
     */
    public @Override String toString() {
        String res= "[";
        // invariant: res = "[s0, s1, .., sk" where sk is the object before node n
        for (Node n = head; n != null; n= n.succ) {
            if (n != head)
                res= res + ", ";
            res= res + n.data;
        }
        return res + "]";
    }

    /**
     * Return "[sn, .., s1, s0]" where (s0, s1, .., sn) are strings representing
     * the objects contained in this, in order.  Uses toString to convert the
     * objects to strings.
     *
     * For example, if this contains 6 3 8 in that order, the result is "[8, 3, 6]".
     */
    public String toStringRev() {
        // TODO item #3
        // This should use field tail and the pred fields in nodes.
        // Do NOT use field size.
    	String res= "[";
        // invariant: res = "[s0, s1, .., sk" where sk is the object before node n
        for (Node n = tail; n != null; n= n.pred) {
            if (n != tail)
                res= res + ", ";
            res= res + n.data;
        }
        return res + "]";
    }
    
    /**
     * Place element in a new node at the end of the list and return the new node.
     * This operation must take constant time.
     */
    private Node append(E element) {
        // TODO item #4
        // This mid-size helper function will be used by other methods
    	
    	/**Construct new node*/
    	Node n = new Node(tail, element, null);
    	
    	/**If the head is null, then the list is empty and Node n must be set as first*/
    	if (head == null)
    		head = n;
    	
    	/**If the tail is NOT null, then the appended Node n must be set as the node
    	 * succeeding the tail
    	 */
    	if (tail != null)
    		tail.succ = n;
    		
    	/**If the tail IS null, then the appended Node n must be set as the new tail*/
    	tail = n;
    	size += 1;
    	return n;
    }
    
    /** Append element to the end of this list and return true. */
    public @Override boolean add(E element) {
        // TODO item #5
        // Rely on helper methods to keep this method small
        // This is THE MOST IMPORTANT method to get right because it will be used
        // in nearly every test
    	this.append(element);
    	return true;
    }
    
    /**
     * Return the Node at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    private Node getNode(int index) {
        // TODO item #6
        // This large helper method is used more than any other helper method
        // It is used by other public methods or for testing.
        // Note that there are two ways to get to a node: from the head or from the tail.
        // This MUST use the fastest way for index.
        // (If h is exactly the middle, then either way is ok.)
    	
    	/**check if index is out of bounds*/
    	if (index <0 || index >= size-1) {
    		throw new IndexOutOfBoundsException();
    	}

    	Node n;
    	/** if size/2 < size-1-index, then you should start searching from head*/
    	if (size-1-index < size/2) {
    		n = head;
    		for (int i = 0; i<index; i++) {
    			n = n.succ;
    			}
    		}

    	/** if (size-index) <= 0, then you should start searching from tail*/	
    	else  {
    		n = tail;
    		for (int i = size-1; i<index; i--) {
    			n = n.pred;
    		}		
    	}
    	return n;
    }
    
    /**
     * Return the Node at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    public @Override E get(int index) {
        // TODO item #7
        // Rely on helper methods to keep this method small.
        // Note that the helper method could throw the exception; doesn't
        // have to be done here.

    	return getNode(index).data;
    }
    
    /**
     * Replace the element at the given index of this list with e.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @param e     the new value to place in the list
     * @return      the former value stored at the index
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    public @Override E set(int index, E element) {
        // TODO item #8
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
    	
    	/**Get Node specified by index*/
    	
    	Node n = getNode(index);
    	
    	/**Store old data of indexed node*/
    	E oldData = n.data;
    	
    	/**Replace old data in with element E*/
    	n.data = element;
    	
    	//return previously stored data of indexed node
    	return oldData;
    }
    
    /**
     * Insert element in a new node at the beginning of the list and return the
     * new node.
     * Runs in constant time.
     */
    private Node prepend(E element) {
        // TODO item #9
        // This mid-size helper function will be used by other methods
    	
    	/**Construct new node to be prepended to linked list*/
    	Node n = new Node(null, element, head);
    
    	/**If the head is not null, then have the head's pred field (which points to the
    	 * previous node), point to the node to be prepended to the list
    	 */
    	if (head != null) {
    		head.pred = n;
    	}
    	
    	head = n;
    	size += 1;
    	return n;   	
    }
    
    /**
     * Insert element into a new node before Node node and return the new node.
     * Takes constant time.
     *
     * @param element the element to insert
     * @param node a non-null Node that must be in this list
     */
    private Node insertBefore(E element, Node node) {
        // TODO item #10
        // This mid-size helper function will be used by other methods.
        // Do NOT test whether node is actually a Node of this list because
        // it will then not be a constant-time operation.
    	
    	/**Per instruction, node must be in this list*/
    	boolean in_list = false;
    	for (Node n1 = head; n1 != null; n1 = n1.succ) {
    		if(node.equals(n1))
    			in_list = true;
    	}
    	
    	/**Per instruction, node must not be null*/
    	assert node != null;
    	
    	//if there is no node preceding Node node, then just prepend
    	if (node.pred == null) {
    		prepend(element);
    	}
    	
    	else {
    		/**Construct new node n, to be inserted before Node node, and after the previous 
        	 * preceding node, Node node.pred*/
        	
        	Node n = new Node(node.pred, element, node);
        	
        	node.pred.succ = n;
        	node.pred = n;
        	size += 1;
        	return node;
    	}
    	return node;
    }
    
    /**
     * Insert e into this list at position i.
     * The element currently at index i, as well as all later elements, are
     * shifted down to make room for element.
     * Takes time proportional to min (index, size - index).
     *
     * @param e the element to insert
     * @param i the place to put e, in [0..size] (note: i == size is allowed!)
     * @throws IndexOutOfBoundsException if i is not in [0..size]
     */
    public @Override void add(int index, E element) {
        // TODO item #11
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
    	
    	if (index != size) 
    		insertBefore(element, getNode(index));
    	else 
    		append(element);
    }
    
    /**
     * Remove n from this list and return its data.
     *
     * @param  n the node to remove.  It must be in this list and non-null.
     * @return the data inside of n
     */
    private E removeNode(Node n) {
        // TODO item #12
        // This is a large helper method
    	
    	boolean in_list = false;
    	for (Node n1 = head; n1 != null; n1 = n1.succ) {
    		if (n.equals(n1))
    			in_list = true;
    	}
    	
    	assert(in_list);
    	if (n.pred != null)
    		n.pred.succ = n.succ;
    	if (n.succ != null)
    		n.succ.pred = n.pred;
    	size -= 1;
    	return n.data;
    	
    }
    
    /**
     * Remove and return the element at index i.
     * Takes time proportional to min(i, size - i).
     *
     * @param i the index of the element to remove, in [0..size).
     *          0 is the first element, 1 is the second, etc.
     * @return the removed element
     * @throws IndexOutOfBoundsException if i is not in [0..size)
     */
    public @Override E remove(int i) {
        // TODO item #13
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
    	
    	Node n = getNode(i);
    	
    	if (n.pred != null)
    		n.pred.succ = n.succ;
    	if (n.succ != null)
    		n.succ.pred = n.pred;
    	size -= 1;
    	return n.data;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    /** An instance is a node of this list. */
    private class Node {
        /** Predecessor of this node on list (null if this is the first node). */
        private Node pred;
        
        /** The data in this element. */
        private E data;
        
        /** Successor of this node on list. (null if this is the last node). */
        private Node succ;
        
        /** Constructor: an instance with predecessor node p (can be null),
          * successor node s (can be null), and data e. */
        private Node(Node p, E e, Node s) {
            this.pred = p;
            this.succ = s;
            this.data = e;
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Glass-box tests for DLinkedList.  Since this is an inner
     * class, it has access to DLinkedList's private types, fields, and methods.
     */
    public static class Tests {

        /**
         * Asserts that list satisfies its invariants.  It is useful to call
         * this after any tests that modify a linked list to ensure that the
         * list remains well-formed.
         *
         * @throws AssertionFailedError if the list is not well-formed
         */
        private static void assertInvariants(DLinkedList<?> list) {
            //throw new NotImplementedError();
        }

        @Test
        public void testAppend() {
            DLinkedList<String> ll     = new DLinkedList<String>();
            DLinkedList<String>.Node n = ll.append("Mike");
            assertEquals("[Mike]", ll.toString());
            assertEquals("[Mike]", ll.toStringRev());
            assertEquals(1, ll.size());
            assertEquals(ll.tail, n);   
        }

        /** Compare DLinkedList to standard library list */
        @Test
        public void testToString() {
            List<Integer>  ll = new java.util.LinkedList<Integer>();
            List<Integer> dll = new DLinkedList<Integer>();
            
            assertEquals(dll.toString(), ll.toString());

            dll.add(5); ll.add(5);
            assertEquals(dll.toString(), ll.toString());
            
            dll.add(4); ll.add(4);
            assertEquals(dll.toString(), ll.toString());
        }
        
        @Test
        public void testToStringRev() {

            DLinkedList<Integer> dll = new DLinkedList<Integer>();
            
            dll.add(5); 
            dll.add(4);
            
            assertEquals(dll.toStringRev(), "[4, 5]");
        	
        }
        
        //test Constructor
        @Test
        public void testConstructor() {
        	DLinkedList<String> a = new DLinkedList();
        	assertEquals(a.head, null);
        	assertEquals(a.tail, null);
        	assertEquals(a.size, 0);
        
        }
        
        //test size()
        @Test
        public void testSize() {
        	DLinkedList<Integer> a = new DLinkedList();
        	
        	//test empty linked list
        	assertEquals(a.size(), 0);
        	
        	//test linked list w. multiple integer elements
        	a.add(5);
        	a.add(4);
        	assertEquals(a.size(), 2);
        }
        
        //test add(E element)
        @Test
        public void testAdd() {
        	DLinkedList<Integer> a = new DLinkedList();
        	
        	//append integers and check if it results in correct size and appropriate index=element match
        	a.add(1);
        	a.add(2);
        	a.add(3);
        	
        	assertEquals(a.get(0), 1);
        	assertEquals(a.get(1), 2);
        	assertEquals(a.get(2), 3);
        	
        	assertEquals(a.size(), 3);
        }
        
        //test getNode(index)
        @Test
        public void testGetNode() {
        	//didn't bother testing index-out-of-bounds exception
        	//Odd # elements, with index closer to head
        	DLinkedList<Integer> alpha = new DLinkedList();
        	
        	
        	a = Node(null, 1, b);
        	b = Node(a, 2, c);
        	
        	a.add(1);
        	a.add(2);
        	a.add(3);
        	a.add(4);
        	a.add(5);
        	a.add(6);
        	a.add(7);
        	
        	assertEquals(a.get(1), 2);
        	
        	//Odd # elements, with index closer to tail
        	assertEquals(a.get(5), 6);
        	
        	//Odd # elements, with index in center
        	assertEquals(a.get(3), 4);
        	
        	//Even # elements
        	DLinkedList<Integer> b = new DLinkedList();
        	b.add(1);
        	b.add(2);
        	b.add(3);
        	b.add(4);
        	b.add(5);
        	b.add(6);
        	assertEquals(b.get(2), 3);
        }
        
        //test get(index)
        @Test
        public void testGet() {
        	DLinkedList<Integer> a = new DLinkedList();
        	a.add(1);
        	a.add(2);
        	a.add(3);
        	
        	
        }
        
    }
}

