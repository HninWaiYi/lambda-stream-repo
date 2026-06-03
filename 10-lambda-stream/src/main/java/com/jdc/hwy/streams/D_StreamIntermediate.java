package com.jdc.hwy.streams;

import java.util.stream.IntStream;

public class D_StreamIntermediate {
	
	public static void main(String[] args) {
//		distinctSkiplimit();
		useSorting();
	}
	
	static void useSorting() {
		IntStream.of(2,4,2,3,4,2,3,4,6,1,5,7,8,9)
		.distinct()
		.sorted()
		.skip(3)
		.forEach(System.out :: println);
	}
	
	static void distinctSkiplimit() {
		IntStream.of(2,4,2,3,4,2,3,4,6,1,5,7,8,9)
		.distinct()   // remove duplicate element 2,2,3,4,4
		.skip(2)   // skip 2,4
		.limit(5)  // remove 8,9 
		.forEach(System.out :: println);;
	}

}
