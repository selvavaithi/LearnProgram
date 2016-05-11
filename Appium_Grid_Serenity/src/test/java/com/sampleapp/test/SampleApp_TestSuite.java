package com.sampleapp.test;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class SampleApp_TestSuite extends SerenityStories {

	public SampleApp_TestSuite() {

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"deviceName:192.168.56.101:5555");

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(), "version:6.0");

		// 192.168.56.101:5555
		// Google_Nexus_9___6_0_0___AP I_23___1536x2048

		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(),
				"app=D:/WorkSpace/Driver/selendroid-test-app-0.17.0.apk");
	}

	@Override
	public List<String> storyPaths() {

		return Arrays.asList("Stories/SampleAppStories/simpleapp.story");
	}

}
