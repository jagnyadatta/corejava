package com.self.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateElement {
	
	public static Integer getDuplicateElement(List<Integer> numbers){
		
		
     int total=numbers.stream().mapToInt(i->i).sum();
    int num=numbers.size()-1;
     
     int duplicate= total-(num*(num+1)/2);
		
		return duplicate;
	}
	
	
	
	public static void main(String[] args) {
		List<Integer> numbers=new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++) {
			numbers.add(i);	
			
		}
		numbers.add(8);
		
		
	System.out.println(getDuplicateElement(numbers));
	}

}
