package com.jdc.hwy.lambda;

@SuppressWarnings("unused")
public class C_MethodReference {
	
	public void sayHello() {
		System.out.println("Using");
	}

	public static void main(String[] args) {
		useLambda();
		System.out.println();
		useMethodReference();
	}
	
	static void useMethodReference() {
//	void useMethodReference() {
		FunctionalOne one = FunctionalReference :: useStatic; //useStatic = new
		one.withoutReturn("one ref");
		
//		FunctionalReference ref = new FunctionalReference("20"); //useInstance is instance method.so, object create
		FunctionalTwo two = new FunctionalReference("20") :: useInstance; //FunctionalTwo two = ref :: useInstance;
		System.out.println(two.withReturn("two ref"));
		
		FunctionalThree three = FunctionalReference :: new; //new = static, new for constructor
		three.withoutReturn("30");

//		sayHello instance method is in current class//do not use static method
//		FunctionalFour four = this :: sayHello;
//		four.withoutReturn();
	}
	
	static void useLambda() {
		FunctionalOne one = s -> System.out.println(s);
		one.withoutReturn("Functional One.");
		
		FunctionalTwo two = s -> s + " two.";
		System.out.println(two.withReturn("Functional"));
		
		FunctionalThree three = a -> System.out.println("Functionsl Three.");
		three.withoutReturn("40");
		
	}
}

@FunctionalInterface
interface FunctionalOne{
	void withoutReturn(String message);
}

@FunctionalInterface
interface FunctionalTwo{
	String withReturn(String message);
}

@FunctionalInterface
interface FunctionalThree{
	void withoutReturn(String a);
}

@FunctionalInterface
interface FunctionalFour{
	void withoutReturn();
}

class FunctionalReference{
	public FunctionalReference(String a) {
		System.out.println("Using Constructor !");
	}
	
	static void useStatic(String mess) {
		System.out.println("Using static method reference with :: "+mess);
	}
	
	String useInstance(String mess) {
		return "Using instance method with :: "+mess;
	}
}