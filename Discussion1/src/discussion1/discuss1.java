package discussion1;
public class discuss1 {

	public static boolean containsVowel(String s) {
		//Part 1: Check if vowel contained in string
		
		/**indexOf returns -1 if no instance of specified character is found in string
		 * Thus, each vowel could be searched for separately throughout the string 
		 * If any vowel is found to be present, method returns true
		 * Series of if statements was used
		 */
		if ((s.indexOf('a'))>=1) {
			return true;
		}
		if ((s.indexOf('e'))>=1) {
			return true;
		}
		if ((s.indexOf('i'))>=1) {
			return true;
		}
		if ((s.indexOf('o'))>=1) {
			return true;
		}
		if ((s.indexOf('u'))>=1) {
			return true;
		}
		return false;
	}
	
	/**main will allow us to run and test each of the three methods we created*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test Part 1:
		System.out.println(containsVowel("Hello world!"));
		//Test Part 2:
		System.out.println(dateToString(5, 6, 2001));
		//Test Part 3:
		System.out.println(countEs("elephant"));
		
	}
	
	
	/**dateToString reads out the appropriate message matching m to the appropriate 
	 * month name. The function .toString was used to convert int d and int y 
	 * to Strings. 
	 * @param d an integer in range 1-31, representing the day
	 * @param m an integer in range 1-12, representing the month
	 * @param y an integer in the range 0-infinity, representing the year
	 * @return
	 */
	public static String dateToString(int d, int m, int y) {
		//convert parameters to strings
		if (m==1) {
			return Integer.toString(d) + " January " + Integer.toString(y);
		}
		if (m==2) {
			return Integer.toString(d) + " February " + Integer.toString(y);
		}
		if (m==3) {
			return Integer.toString(d) + " March " + Integer.toString(y);
		}
		if (m==4) {
			return Integer.toString(d) + " April  " + Integer.toString(y);
		}
		if (m==5) {
			return Integer.toString(d) + " May " + Integer.toString(y);
		}
		if (m==6) {
			return Integer.toString(d) + " June " + Integer.toString(y);
		}
		if (m==7) {
			return Integer.toString(d) + " July " + Integer.toString(y);
		}
		if (m==8) {
			return Integer.toString(d) + " August " + Integer.toString(y);
		}
		if (m==9) {
			return Integer.toString(d) + " September " + Integer.toString(y);
		}
		if (m==10) {
			return Integer.toString(d) + " October " + Integer.toString(y);
		}
		if (m==11) {
			return Integer.toString(d) + " November " + Integer.toString(y);
		}
		if (m==12) {
			return Integer.toString(d) + " December " + Integer.toString(y);
		}
		return "true";
	}
		
	/**int x is initialized as a counter variable. The for loop iteratively traverses
	 * each character in the string until the end; Each time an instance of e is found, 
	 * the counter variable x is increased by 1 to tally a count.
	 * @param s a string taken as the argument of this method, which will count 
	 * the # of e's in it
	 * @return returns the counter variable x, which tallied the number of instances
	 * of e
	 */
	public static int countEs(String s) {
		int x=0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == 'e') {
					x++;
			}
		}
	return x;
	}
}

