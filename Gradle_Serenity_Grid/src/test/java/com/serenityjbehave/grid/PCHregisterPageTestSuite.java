package com.serenityjbehave.grid;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class PCHregisterPageTestSuite extends SerenityStories {
	public PCHregisterPageTestSuite() {
		String dirPath = System.getProperty("user.dir");
		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName(),
				dirPath + "/target/site/serenity/");
	}

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("stories/pch.story");
	}
}
