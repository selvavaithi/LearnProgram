package com.sampleapp.test;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class SampleAppTest extends SerenityStories {

	public SampleAppTest() {
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"deviceName:192.168.56.101:5555");
	}

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("Stories/SampleAppStories/simpleapp.story");
	}

}
