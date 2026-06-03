package com.jdc.hwy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class C_StreamIntermediate {

	public static void main(String[] args) {
//		useFilter();
//		useMap();
//		useFlatMap();
//		useMapMultiVsFlatMap();
		usePeek();
	}
	
	static void usePeek() {
		var sum = IntStream.of(1,2,3,4).peek(num -> System.out.println("use peek :: "+num)).sum();
		System.out.println(sum);
	}
	
	static void useMapMultiVsFlatMap() {
		List<String> list = List.of("A,B,C", "A,b", "D,E");
		var flats = list.stream().flatMap(m -> Arrays.stream(m.split(","))).toList();
		System.out.println("Use FlatMap :: "+flats);
		
		var multi = list.stream().mapMulti((element, consumer) -> {
			for(String s : element.split(",")) {
				consumer.accept(s);
			}
		}).toList();
		System.out.println("Use MapMulti :: "+multi);
	}
	
	static void useFlatMap() {
	List<List<Integer>> list = List.of(
			List.of(2, 3),
			List.of(4, 5),
			List.of(1, 2)
			);
	
	var list1 = list.stream()
			.flatMap(f -> f.stream())
			.collect(Collectors.toList());
	
	System.out.println(list);
	System.out.println(list1);
	}
	
	static void useMap() {
		var stream = Stream.of("4", "3", "5", "2","1");
		
//		stream.map(e -> Integer.parseInt(e)).forEach(System.out :: println);		
		stream.mapToInt(Integer :: parseInt).forEach(System.out :: println);
		
		LongStream.of(2, 4, 5, 6, 2)
		.mapToDouble(d -> Double.valueOf(d))
		.forEach(System.out :: println);
	}
	
	static void useFilter() {
//		Java 9 (takeWhile and dropWhile)
//		Should be order and sequential
		LongStream.rangeClosed(1, 10).takeWhile(l -> l < 5).forEach(System.out :: println);
		System.out.println("====================================");
		
		LongStream.rangeClosed(1, 10).dropWhile(l -> l < 5).forEach(System.out :: println);
		System.out.println("====================================");
		
		IntStream.rangeClosed(1, 10)
		.filter(a -> (a%2) == 0)
		.forEach(System.out :: println);
		System.out.println("====================================");
		
		List.of("Andrew", "John", "Willam", "Jarassic", "Jacob")
		.stream()
		.filter(e -> e.startsWith("J"))
		.forEach(System.out :: println);
		
	}
}
