package com.self.array;

public class ReverseNumber {
	
	public static void main(String[] args) {
		int a=1234;
		int num =0;
		
		while (a!=0){			
		num=(num*10)+(a%10);
		a=a/10;			
			
		}
		
		System.out.println(num);
		
	}

}
