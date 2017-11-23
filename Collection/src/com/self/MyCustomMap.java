package com.self;

import java.util.Arrays;

public class MyCustomMap<K,V> {
	
	private int size;
	private int default_capacity=16;
	private MyEntry<K, V>[] values=new MyEntry[default_capacity];
	
	int size(){
		return size;
	}
	
	
	
	public static void main(String[] args) {
		MyCustomMap< Integer, String> map=new MyCustomMap<>();
		
		
		System.out.println(map.size());
	}
	private void ensureCapa() {
	    if (size == values.length) {
	        int newSize = values.length * 2;
	        values = Arrays.copyOf(values, newSize);
	    }
	}

}
