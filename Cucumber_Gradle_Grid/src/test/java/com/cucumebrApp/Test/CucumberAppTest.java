package com.cucumebrApp.Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/appfeature/features")
public class CucumberAppTest {

	public CucumberAppTest() {
		super();
	}

}
