package Lectures; 
public class StackDemo {
	
	public static void f() {
		int x = 1;
	}

	public static void g() {
		int x = 2;
		f();
		f();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		int y = 4;
		g();
		g();
		f();
	}

}