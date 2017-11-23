package com.self;

public class Test {
	public static void main(String[] args) {
		  String s1= "Anagram"; 
		    String s2= "margana";  
		    // We make use of the fact that a char does also represent an int.
		    int lettersS1[] = new int[1900];
		    int lettersS2[] = new int[7];
		    
		    
		    for (int i = 0; i < lettersS2.length; i++) {
		    	System.out.println(++lettersS1[s1.toLowerCase().charAt(i)]);
			}
	}

}
