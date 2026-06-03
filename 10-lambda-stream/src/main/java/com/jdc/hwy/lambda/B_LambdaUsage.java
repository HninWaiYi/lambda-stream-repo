package com.jdc.hwy.lambda;

public class B_LambdaUsage {
	
	public static void main(String[] args) {
		withoutLambda();
		withLambda();
	}
	
	static void withLambda() {
		Producer p = () -> 30;
		System.out.println(p.produce());
		
		Consumer c = a -> System.out.println(a);
		c.set("test");
	}
	
	static void withoutLambda() {
		Producer p = new Producer() {
			
			@Override
			public int produce() {
				return 30;
			}
		};
		System.out.println(p.produce());
		
		Consumer c = new Consumer() {
			
			@Override
			public void set(String a) {
				System.out.println("Consumer ::: "+a);			
			}
		};
		c.set("test");
	}
}

@FunctionalInterface
interface Producer{
	int produce();
}

@FunctionalInterface
interface Consumer{
	void set(String a);
}