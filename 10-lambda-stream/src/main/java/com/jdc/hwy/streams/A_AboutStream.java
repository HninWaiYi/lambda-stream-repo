package com.jdc.hwy.streams;

import java.util.List;

public class A_AboutStream {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Before Stream ::: "+beforeStream(list)); 
		System.out.println("After Stream ::: "+afterStream(list)); 
	}
	
//	Declarative
	static int afterStream(List<Integer> list) {
		return list.stream().mapToInt(i -> i).sum();
	}
	
	
//	Imperative
	static int beforeStream(List<Integer> list) {
		int sum = 0;
		
		for(int a : list) {
			sum += a;
		}
		return sum;
	}
}
