package Lectures;

public class HeapDemo {

	int x = 0;
	String y = "hello";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapDemo hd = new HeapDemo();
		//<object>.<thing> means go find the <thing> in <object>
		hd.x = 1;
		
		HeapDemo hd2 = new HeapDemo();
		hd2.x = 2;
		//hd1 and hd2 are local variables that point to two different HeapDemos*/
		
		
		
		HeapDemo hd3 = hd2;
		hd3.x = 3;
		
		//hd3 and hd2 point to the same thing; 
		//after execution, hd2.x will be set to 3, not 2. 
		//it will change in both hd2 and hd3 to 3 b/c they're both pointers to same object
		
	}

}
