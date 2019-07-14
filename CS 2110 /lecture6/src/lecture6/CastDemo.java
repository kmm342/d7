package lecture6;

public class CastDemo {
	
	public static interface Animal {
		void beCute();
	}

	public static interface Mammal extends Animal {
		void giveMilk();
		
	}
	
	public static interface Dog extends Mammal {
		void bark();
	}
	
	public static void main(String[] args) {
		Animal a;
		a = new DogImpl(); //ok, b/c every DogImpl is an Animal
		a.beCute();
		
		//Mammal m = a; //error! type cast
		Mammal m = (Mammal) a; //compiles, but dangerous
		
		a = new Lizard(); //error: bc Lizards cannot be cast to Mammal
	}
	
	public static class Lizard implements Animal {

		@Override
		public void beCute() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public static class DogImpl implements Dog {

		@Override
		public void giveMilk() {
			// TODO Auto-generated method stub
			System.out.println("Here is some dog milk");
		}

		@Override
		public void beCute() {
			// TODO Auto-generated method stub
			System.out.println("I'm shaking hands");
		}

		@Override
		public void bark() {
			// TODO Auto-generated method stub
			System.out.println("bark bark bark");
			
		}
		//method that has signature but no implementation = abstract Method; must be implemented
	}
	
	public static class CowImpl implements Mammal {

		@Override
		public void beCute() {
			// TODO Auto-generated method stub
			System.out.println("moo");
			
		}

		@Override
		public void giveMilk() {
			// TODO Auto-generated method stub
			System.out.println("here is some cow milk");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = Double.MAX_VALUE;
		System.out.println(d);
		
		int i = (int) d;
		System.out.println(i);
		
		char c = (char) i;
		System.out.println("char " + c);
		System.out.println("int again: " + (int) c);
		//approximations and precision lost
	}

}
