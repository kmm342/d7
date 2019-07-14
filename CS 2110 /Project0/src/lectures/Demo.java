package lectures;

public class Demo {
	
	public f(int x) {
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("hello world");
		System.out.println(3+4);
		System.out.println(true);
		
		
		//Java is statically typed
		//Python, matlab are dynamically typed
		
		//static means determined when you WRITE the program
		// (compile-time); while you write program you know 
		//something about what's going to happen
		
		int x;			/* had to declare x first */
		x = 7;
		
		
		//Primitive Types
		//built into language itself; ~7-8 primitive types
		//ints
		System.out.println("Max Integer:" + Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE + 1);
		
		//boolean
		boolean z = true;
		z = false;
		System.out.println(true && false); //true AND false
		System.out.println(true || false); //true OR false
		//doubles/floats
		double w = 3.14;
		//chars
		char t = 'a';
		char t2 = '1';
		//char t3 = 'hello'; invalid!//
		
		//Object Types: not built into language itself
		//you can build your own types like string using NEW
		//string
		String x_string = "hello";
		System.out.println(x_string.)
		Demo d = new Demo();
		
		int result_of_f = d.f(3);
		
		
		
		
		
	}
	
	
}
