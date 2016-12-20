package com.common.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;


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
		String tt = "file.ASPX";
		System.out.println(tt.replaceAll(".ASPX", ""));
		System.out.println(b.x); // prints 20
		System.out.println(bn.x); // prints 50
		// This can be accsed as static way BaseFun.x yet for understanding
		// placing it like this.

		Base.MethodsOverride(x);// prints 50
		System.out.println("before");
		JOptionPane.showConfirmDialog(null, "MESSAGE", "TITLE", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

		JOptionPane.showMessageDialog(null, "Loading Complete...!!!"); // selected
		
		Object[] options = { "OK" };
		int n = JOptionPane.showOptionDialog(null, "Message here ", "Title", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.out.println("Random name: "+getName());
		
		CalendarFun();
		
	}
	
	private static void CalendarFun() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formate = new SimpleDateFormat("MM/dd/yyyy");
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)-14);
		Date myDate = cal.getTime();
		System.out.println(formate.format(myDate));
		
	}

	public static String getName() {
 		return firstCharUppercase((org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(15)).replaceAll("f", "z").replaceAll("F", "Z"));
	
	}

	private static String firstCharUppercase(String name) {
		return Character.toString(name.charAt(0)).toUpperCase()
				+ name.substring(1);
	}

}
