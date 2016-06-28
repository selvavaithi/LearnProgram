package com.common.test;

class Base {
	int x = 20;

	static void MethodsOverride(int x) {
		System.out.println(x);
	}
}

public class BaseFun extends Base {
	static int x = 50;

	public static void main(String arg[]) {
		Base b = new BaseFun(); // upcasting
		BaseFun bn = new BaseFun();
		
		System.out.println(b.x); // prints 20
		System.out.println(bn.x); // prints 50
		//This can be accsed as static way BaseFun.x yet for understanding placing it like this.
		
		Base.MethodsOverride(x);// prints 50
	}
}
