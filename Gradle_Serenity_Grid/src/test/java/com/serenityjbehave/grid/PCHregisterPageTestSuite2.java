package com.serenityjbehave.grid;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class PCHregisterPageTestSuite2 extends SerenityStories {

	public PCHregisterPageTestSuite2() {

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(), "browserName:chrome");
		String dirPath = System.getProperty("user.dir");
		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName(),
				dirPath + "/target/site/serenity/");
		
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.PROPERTIES.from(getEnvironmentVariables(), "true"),
				"serenity2.properties");
		// ThucydidesSystemProperty.PROPERTIES.from(getEnvironmentVariables(),
		// "serenity2.properties");
	}

	@Override
	public List<String> storyPaths() {
		// TODO Auto-generated method stub
		return Arrays.asList("stories/pch2.story");
	}

}
