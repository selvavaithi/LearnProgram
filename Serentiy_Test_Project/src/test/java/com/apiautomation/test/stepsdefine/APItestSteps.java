package com.apiautomation.test.stepsdefine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.apiautomation.test.steps.APItestStepsModules;

import net.thucydides.core.annotations.Steps;

public class APItestSteps {
	String coordinatesforArea, coordinatesForNearBy;

	@Steps
	APItestStepsModules apiteststepsmodules;

	@Given("I search for $str in google api")
	public void givenISearchForInGoogleApi(@Named("str") String str) {
		apiteststepsmodules.getAddressOfstr(str);

		Connection conn = null;
		String url = "jdbc:sqlserver://localhost:1433;databaseName=master;integratedSecurity=true";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String userName = "sa";
		String password = "P@ssword12";
		Statement stmt;

		try {
			Class.forName(driver);
			System.out.println("1235");
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("1236");
			String query = "select * from User_table";
			stmt = conn.createStatement();
			int flag = stmt.executeUpdate(query);
			System.out.println("flag = " + flag);
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("connenction closed");

	}

	@When("I search for $nearby that are near $area in google map api")
	public void whenISearchForHotelsNearSoftcrylicChennaiInGoogleApi(@Named("nearby") String nearby,
			@Named("area") String area) {
		apiteststepsmodules.getAddressofNearBy(nearby, area);
		coordinatesforArea = area;
		coordinatesForNearBy = nearby;
	}

	@Then("I print coordinates")
	public void thenIPrintCoordinates() {
		apiteststepsmodules.printNearByCoordinates(coordinatesforArea, coordinatesForNearBy);
	}
}