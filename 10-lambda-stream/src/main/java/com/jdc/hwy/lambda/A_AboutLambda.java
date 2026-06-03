package com.jdc.hwy.lambda;

public class A_AboutLambda {
	
	public static void main(String[] args) {
		beforeLambda();
		afterLambda();
	}
	
	static void afterLambda() {
		Order order = (a, b) -> a+b;
		String res = order.checkout(4000, "kyats");
		System.out.println(res);
	}

	static void beforeLambda() {
		Order order = new Order() {

			@Override
			public String checkout(int a, String b) {
				return a + b;
				
			}
			
		};
		String res = order.checkout(1, "$");
		System.out.println(res);
	}
}

@FunctionalInterface
interface Order{
//	Effective final
	String name = "no name";
	
	String checkout(int a, String s);
	
	default void show() {}
	static void doSomething() {}
}