package com.cirrusled.assessment;

import javafx.scene.control.TextField;

public class LongestPalindromeSearch 
{

	long minValue, maxValue;
	

	public LongestPalindromeSearch(long minValue, long maxValue )
	{
		this.minValue=minValue;
		this.maxValue=maxValue;
	}
	
	public String searchPalindrome()
	{
		for(long temp = maxValue; temp >= minValue; temp--)
		{
			if(isPalindromic(temp))
			{
				return (temp+"");
			}
		}
		return "No Plaindromic Numbers input range";
	}
	public boolean isPalindromic(long input)
	{
		String number = Long.toString(input);
		StringBuffer transNumber = new StringBuffer(number);
		transNumber = transNumber.reverse();
		if(transNumber.toString().equals(number))
		{
			return true;
		}
		return false; 
	}
	
}
