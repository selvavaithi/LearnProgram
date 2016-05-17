package com.appsaucelabs.test.App_Saucelabs_Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThisIsTestNG {

	@BeforeClass
	public static void setUp() {
		System.out.println("Before set up");
	}

	@Test
	public void test1() {
		System.out.println("Test");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("After teardown");
	}

}
