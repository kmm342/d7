package b1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercises {
	
	/**
	 * Determines whether the string s is a palindrome.
	 * @param s string to test.
	 * @return True if s is a palindrome, false otherwise.
	 */
	public static boolean isPalindrome(String s){
		int len = s.length();
		StringBuilder backwards = new StringBuilder();
		for(int i = len - 1; i >= 0; i--) {
			backwards.append((s.charAt(i)));
		}
		String backwards_string = backwards.toString();
		if(s.compareTo(backwards_string) == 0)
			return true;
		else
			return false;
	}
	
	
	/**
	 * Takes a string s and removes all non-alphanumeric characters.
	 * @param s string to normalize.
	 * @return the normalized version of string s.
	 */
	public static String normalize(String s){
		String new_string = "";
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetterOrDigit(s.charAt(i)))
				new_string += s.charAt(i);
		}
		return new_string;
	}
	
	/**
	 * Finds the median value from an array of integers. 
	 * When there are an even number of ints, defaults to the value with a lower position.
	 * @param values array of integers.
	 * @return the median value of all integers in the array values.
	 */
	public static int median(int[] values) {
		assert values.length > 0;
		Arrays.parallelSort(values);
		int len = values.length;
		return values[(len-1)/2];
	}
	
	/**
	 * Finds the number of zeroes in the array.
	 * @param values array of integers.
	 * @return the number of zeroes in the array values.
	 */
	public static int numZeroes(int []values){
		int count = 0;
		for(int i = 0; i < values.length; i++) {
			if(values[i] == 0)
				count++;
		}
		return count;
	}
	
	/**
	 * Finds the mean of an array of integers.
	 * @param values array containing integers.
	 * @return The mean of the integers in the array values. Zero if an empty array.
	 */
	public static double mean(int[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum/values.length;
	}
	
	/**
	 * Determines if all the values on the main diagonal of a 2x2 array are equal.
	 * @param values a 2x2 array of integers.
	 * @return True if all values on the main diagonal are equivalent.
	 */
	public static boolean hasConstDiagonal(int[][] values) {
		assert values.length > 0;
		assert values.length == values[0].length;
		
		boolean constDiag = true;
		int previous = values[0][0];
		for(int i = 1; i < values.length; i++) {
			if(!(values[i][i] == previous))
				constDiag = false;
			previous = values[i][i];
		}
		return constDiag;
	}
}


