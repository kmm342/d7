package discussion3;

public class ClassA {

	public static double p(int x) {
		int y = x;
		//scrap
		//scrap2
		int a;
		a = 1;
		try {
			System.out.println("six");
			y = 5/x;
			System.out.println("five");
			return 5/(x+2);
		} catch (RuntimeException e) {
			System.out.println("four");
			y = 5/(x+1);
			System.out.println("three");
		}
		System.out.println("two");
		y = 4/x;
		System.out.println("one");
		return 1/x;
		}
	public static void main(String[] args) {
		p(0);
	}
}
