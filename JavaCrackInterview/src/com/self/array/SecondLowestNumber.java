package com.self.array;

public class SecondLowestNumber {
	
	static private int[] numbers=new int[]{-8,7,-4,1,4,2,-6,4};
	public static void main(String[] args) {
		
		int secondHighestSal , firstHighestSal;
		secondHighestSal=firstHighestSal=Integer.MAX_VALUE;
		
		for (int i = 0; i < numbers.length; i++) {
			
			if(numbers[i]<firstHighestSal){
				secondHighestSal=firstHighestSal;
				firstHighestSal=numbers[i];
				
				
			}else if(numbers[i] < secondHighestSal && numbers[i]!=firstHighestSal){ 
				secondHighestSal=numbers[i]	;
			}
			
			
			
		}
		System.out.println(secondHighestSal);
		
		
	}

}
