package com.DBtest.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MSSQL_StoredProcedure {

	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mypets;user=superuser;password=Test@123";
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	@BeforeClass
	public static void setup() {

		String classname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		try {
			// Class..
			Class.forName(classname);
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery("getPetbyName @petname='humpy'");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void Test1() {
		try {
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown() {
		try {
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
