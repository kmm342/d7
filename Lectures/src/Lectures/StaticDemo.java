package Lectures;

public class StaticDemo {

	static int x = 0;
	int y = 2;
	
	
	public void f() {
		
	}
	
	public static void g() {
		
	}
	//g is going to live 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticDemo.x = 1;
		
		
		//y doesn't exist: StaticDemo.y = 2;
		StaticDemo sd = new StaticDemo();
		sd.y = 3;
		sd.f(); //cannot do StaticDemo.f() you can only call method if you have object
		
		
//		sd.x = 4; Java allows it, but it should be accessed Statically
		StaticDemo.x = 4;
		
		StaticDemo sd2 = new StaticDemo();
		sd2.y = 5;
		sd2.x = 6;
		//sd.x? 
		//It will be 6
		//y is a field, not a static variable?
	}
}
