package com.jdc.hwy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E_Retrieving {
	
	public static void main(String[] args) {
		var stream = IntStream.of(2,3,4,1,5,2,4,6,7);
//		useSingleResult(stream);
//		useMultipleResult(stream);
//		useReduce(stream);
//		useCollect(stream);
		useIsParallel(stream);
	}
	
	static void useIsParallel(IntStream stream) {
		var res = stream.parallel().sequential().isParallel();
		System.out.println("Is Parallel :: "+res);
	}
	
	static void useCollect(IntStream stream) {
		List<String> list = List.of("a,b", "c,d,e", "g");
		var newList = list.stream()
				.flatMap(m -> Arrays.stream(m.split(",")))
				.collect(Collectors.toList());
		System.out.println(newList);
		
	}
	
	static void useReduce(IntStream stream) {
		var value = stream
				.distinct()
				.sorted()
				.filter(even -> even%2 == 0)
				.reduce(0, (a,b) -> a+b);
		System.out.println("Reduce :: "+value);
	}
	
	static void useMultipleResult(IntStream stream) {
		var array = stream
				.distinct()
				.sorted()
				.filter(even -> even%2 == 0)
				.toArray();
		
		Arrays.stream(array).forEach(System.out :: println);
	}
	
	static void useSingleResult(IntStream stream) {
//		var max = stream.max().getAsInt();
//		System.out.println(max);
		
		var first = stream.findFirst().getAsInt();
		System.out.println(first);
		
//		var count = stream.count();
//		System.out.println(count);
		
		
	}

}
