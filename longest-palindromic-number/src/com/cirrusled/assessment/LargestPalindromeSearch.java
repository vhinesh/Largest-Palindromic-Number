package com.cirrusled.assessment;

import javafx.scene.control.TextField;

/**
 * The program searches for the largest palindromic number within the given
 * range.
 * 
 * @author vhineshravi
 *
 */
public class LargestPalindromeSearch {

	long minValue, maxValue;

	/**
	 * Initializing the lower and upper bounds
	 * 
	 * @param minValue
	 *            the lower bound
	 * @param maxValue
	 *            the upper bound
	 */
	public LargestPalindromeSearch(long minValue, long maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	/**
	 * The function finds the largest palindromic number within the input range.
	 * 
	 * @return largest palindromic number
	 */
	public String searchPalindrome() {
		for (long temp = maxValue; temp >= minValue; temp--) {
			if (isPalindromic(temp)) {
				return (temp + "");
			}
		}
		return "No Plaindromic Numbers input range";
	}

	/**
	 * The function cheeks if given number is palindromic or not
	 * 
	 * @param input
	 *            the input number
	 * @return palindromic or not
	 */
	public boolean isPalindromic(long input) {
		String number = Long.toString(input);
		StringBuffer transNumber = new StringBuffer(number);
		transNumber = transNumber.reverse();
		if (transNumber.toString().equals(number)) {
			return true;
		}
		return false;
	}
}