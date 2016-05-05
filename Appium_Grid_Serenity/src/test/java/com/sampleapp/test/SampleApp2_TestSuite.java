package com.sampleapp.test;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class SampleApp2_TestSuite extends SerenityStories {

	public SampleApp2_TestSuite() {
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"deviceName:4d00af03525c80a1");
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(), "version:5.0.2");

		// 4d00af03525c80a1

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"app=D:/WorkSpace/Driver/selendroid-test-app-0.17.0.apk");
	}

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("Stories/SampleAppStories/simpleapp.story");
	}

}
