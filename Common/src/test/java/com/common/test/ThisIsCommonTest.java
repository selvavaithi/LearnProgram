package com.common.test;

public class ThisIsCommonTest {
	String str;
	public String needfulfilepath=System.getProperty("user.dir") + "\\Needfulfiles\\DataSet.xlsx";
	private String filepath;

	public String getStr() {
		return str;
	}

	public ThisIsCommonTest() {
		super();
		filepath = System.getProperty("user.dir") + "\\Needful\\Book1.xlsx";
	}

	public void setStr(String str) {
		this.str = str;
		System.out.println(filepath);
	}
}
