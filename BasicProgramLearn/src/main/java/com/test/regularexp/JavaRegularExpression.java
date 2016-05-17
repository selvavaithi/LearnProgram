package com.test.regularexp;

public class JavaRegularExpression {

	public static void main(String[] args) {
		String str = " TODO      Auto-generated    method stub ";
		
		String[] strr = str.split("\\s+");
		
		for(String ss:strr){
			System.out.println(ss);
		}

	}

}
