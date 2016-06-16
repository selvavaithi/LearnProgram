package com.DBtest.testing;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MSSQLtest {

	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mypets;user=superuser;password=Test@123";
	private static Statement stmt;
	private static ResultSet result;
	private static String query = "Select * from mypets.dbo.pets mp right join myvalues.dbo.lotto_data_ball lo on mp.id = lo.id_lotto order by mp.petName";
	private ResultSetMetaData rsmd;
	private static Connection con;

	@BeforeClass
	public static void setUp() {
		String classname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		try {
			// Class..
			Class.forName(classname);

			// Connection
			con = DriverManager.getConnection(url);
			
			executeStoredProcedure(con);

			// Statment
			stmt = con.createStatement();

			// Result
			result = stmt.executeQuery(query);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Test1() {

		try {
			rsmd = result.getMetaData();
			System.out.println(rsmd.getColumnCount());
			if (result.next()) {
				while (result.next()) {

					System.out.println("-------------------------------------------");
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.print("\t" + result.getString(i));

					}
					System.out.println();
					/*
					 * String petType = result.getString("petType"); String
					 * petName = result.getString("petName");
					 * 
					 * System.out.println("petType :" + petType + " petName: " +
					 * petName); System.out.println("petName: " + petName);
					 */
				}
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void executeStoredProcedure(Connection con) {
		try {
			CallableStatement cstmt = con.prepareCall("{call dbo.getIdbasedLottoDataBall(?, ?)}");
			cstmt.setInt(1, 5);  
		      cstmt.registerOutParameter(2, java.sql.Types.INTEGER);  
		      cstmt.execute();  
		      System.out.println("MANAGER ID: " + cstmt.getInt(2));  
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void TearDown() {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
