package com.jdc.hwy.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class E_DefaultFunctional {

	public static void main(String[] args) {
		useConsumer(23, 30);
//		useSupplier();
		System.out.println();
		usePredicate(9);
		
		System.out.println();
		useFunction(5);
	}
	
	static void useFunction(int value) {
		Function<Integer, Integer> f = x -> x + 3;
		Function<Integer, Integer> f1 = x -> x * x;
		Function<Integer, Integer> combile = f.andThen(f1);
		System.out.println("Use AndThen :: "+combile.apply(value));
		
//		use method reference
		Function<String, Integer> r = Integer :: parseInt ;
		System.out.println(r.apply("34"));
		
		BiFunction<Integer, Integer, String> b = (x, y) -> "Result : "+(x+y);
		System.out.println(b.apply(20, 30));
	}
	
	static void useOperator() {
		UnaryOperator<String> u = a -> "Use : "+ a;
		System.out.println(u.apply("UnaryOperator"));
		
		BinaryOperator<String> b = (x,y) -> "Use : "+ x+y;
		System.out.println(b.apply("Binary", "Operator"));
	}
	
	static void useSupplier() {
		Supplier<Integer> s = () -> 40;
		System.out.println("Use suplier ::: "+s.get());
	}
	
	static void usePredicate(int value) {
		Predicate<Integer> p1 = a -> a > 0;
		Predicate<Integer> p2 = a -> a < 10;
		Predicate<Integer> p3 = p1.and(p2); //p1.and(p2).negate();
		
		System.out.println("Value is greater than 0 and/or less than 10 :: "+p3.test(value));
		
		BiPredicate<Integer, Integer> bp = (a,b) -> a%b == 0;
		System.out.println("Use BiPredicate ::: "+bp.test(10, 2));
	}
	
	static void useConsumer(int a, int b) {
		Consumer<Integer> c1 = x -> System.out.println("Divided by 2 :: "+(x%2));
		Consumer<Integer> c2 = y -> System.out.println("y is greater than 10 :: "+(y > 10));
		Consumer<Integer> combine = c1.andThen(c2);
		combine.accept(a);
		
		
		BiConsumer<Integer, Integer> c3 = (x, y) -> System.out.println("Use BiConsumer ::: "+(x+y));
		c3.accept(a,b);
		
	}
}
