package com.sampleapp.test;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class SampleApp2_TestSuite extends SerenityStories {

	public SampleApp2_TestSuite() {
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"deviceName:4d00af03525c80a1"); // GT_N7100

		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.WEBDRIVER_REMOTE_URL.getPropertyName(),
				"http://192.168.129.195:4444/wd/hub");

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(), "version:5.0.2");

		// 4d00af03525c80a1

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"app=D:/WorkSpace/Driver/selendroid-test-app-0.17.0.apk");
	}

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("Stories/SampleAppStories/simpleapp2.story");
	}

}
