package com.self;
import java.text.ParseException;

public class Anagram {
	public static void main(String[] args) throws ParseException {
	    String s1= "anagram"; 
	    String s2= "margana";  
	    // We make use of the fact that a char does also represent an int.
	    int lettersS1[] = new int[Character.MAX_VALUE];
	    int lettersS2[] = new int[Character.MAX_VALUE];
	    if(s1.length()!=s2.length())
	       System.out.print("No");
	    else {
	       // Loop through the String once
	       for(int i = 0; i<s1.length() ;++i) {
	           // we can just use the char value as an index
	           // and increase the value of it. This is our identifier how often 
	           // each letter was aviable in the String. Alse case insensitive right now
	           lettersS1[s1.toLowerCase().charAt(i)]++;
	           lettersS2[s2.toLowerCase().charAt(i)]++;
	       }
	       // set a flag if the Strings were anagrams
	       boolean anag = true;
	       // We stop the loop as soon as we noticed they are not anagrams
	       for(int i = 0;i<lettersS1.length&&anag;++i) {
	           if(lettersS1[i] != lettersS2[i]) {
	               // If the values differ they are not anagrams.
	               anag = false;
	           }
	       }
	       // Depending on the former loop we know if these two strings are anagrams
	       if(anag) {
	           System.out.print("Anagram");
	       } else {
	           System.out.print("No anagram");
	       }
	    } 
	}

}
