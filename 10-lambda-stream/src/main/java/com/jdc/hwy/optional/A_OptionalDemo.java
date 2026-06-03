package com.jdc.hwy.optional;

import java.util.Optional;

public class A_OptionalDemo {
	
	public static void main(String[] args) {
		Data d = getData(null)
				.orElseGet(() -> new Data(11));
//				.or(() -> Optionsl.ofNullable(new Data(11))).get();
//				.get();
//				.orElseThrow(() -> new RuntimeException("no data object"));
		var value = d.getValue();
		System.out.println(value);
		
		getData(null).ifPresentOrElse(
				a -> System.out.println(a.getValue()), 
				() -> System.out.println("No Data"));
	}
	
	static Optional<Data> getData(Data data) {
		return Optional.ofNullable(data);
	}

}

class Data{
	private int value;
	
	public Data(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
