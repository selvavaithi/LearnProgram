package com.serenityjbehave.grid;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class PCHregisterPageTestSuite2 extends SerenityStories {

	public PCHregisterPageTestSuite2() {
		
		 getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.PROPERTIES.from(getEnvironmentVariables(),"serenity2.properties"),"serenity2.properties");
		//ThucydidesSystemProperty.PROPERTIES.from(getEnvironmentVariables(), "serenity2.properties");
	}
}
