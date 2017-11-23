package com.self.array;

public class FirstdHighestNumber {
	
	static private int[] numbers=new int[]{-8,7,-4,1,4,2,-6,4};
	public static void main(String[] args) {
		
		int firstHighestSal=Integer.MIN_VALUE;
		
		for (int i = 0; i < numbers.length; i++) {
			
			if(numbers[i]>firstHighestSal){
				firstHighestSal=numbers[i];
			}
			
			
			
		}
		System.out.println(firstHighestSal);
		
		
	}

}
