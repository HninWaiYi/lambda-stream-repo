package com.jdc.hwy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class B_StreamCreation {
	
	public static void main(String[] args) {
//		useCollectionArray();
//		useRange();
//		useIterate();
//		useGenerate();
//		useFactory();
		useBuilder();
	}
	
	static void useBuilder() {
		Stream.builder()
		.add("a")
		.add("b")
		.build().forEach(System.out :: print);
	}
	
	static void useFactory() {
		var stream = Stream.of(1,2,3).mapToInt(i -> i).sum();
		System.out.println("Stream :: "+stream);
		
		var inStream = IntStream.of(2,3,4).sum();
		System.out.println("IntStream :: "+inStream);
	}
	
	static void useGenerate() {
		Random rand =  new Random(); // Effectively Final, cause use in lambda
		int res = IntStream.generate(() -> rand.nextInt(6)).findFirst().getAsInt();
		System.out.println("Random value :: "+res);
	}
	
	static void useIterate() {
		Stream.iterate("a", x -> x).limit(5).forEach(System.out :: println); //.forEach(a -> System.out.println(a))
		System.out.println();
		
		var i = DoubleStream.iterate(1, x -> x+1).limit(5).sum();
		System.out.println("Stream 1 to 5 :: "+i);
		
//		out value => 1(initial value), 2(1*2), 3(2*2) = output 7
		var l = LongStream.iterate(1, x -> x*2).limit(3).sum();
		System.out.println("LongStream 1 to 3 :: "+l);
	}
	
	static void useRange() {
		var i = IntStream.range(1, 10).sum();
		System.out.println("IntStream :: "+i);
		
		var l = LongStream.rangeClosed(1, 10).sum();
		System.out.println("LongStream :: "+l);
	}
	
	static void useCollectionArray() {
		List<String> list = List.of("1", "2", "3", "4","5", "6", "7", "8", "9");
		String[] array = {"1", "2", "3", "4","5", "6", "7", "8", "9"};
		
//		var listRes = list.stream().mapToInt(s -> Integer.parseInt(s)).sum();
		var listRes = list.stream().mapToInt(Integer :: parseInt).sum();
		System.out.println("List result :: "+listRes);
		
		var arrayRes = Arrays.stream(array).mapToInt(Integer :: parseInt).sum();
		System.out.println("Array result :: "+arrayRes);
	}

}
