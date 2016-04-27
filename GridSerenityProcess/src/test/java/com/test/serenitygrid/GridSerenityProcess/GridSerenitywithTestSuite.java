package com.test.serenitygrid.GridSerenityProcess;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class GridSerenitywithTestSuite extends SerenityStories {

	public GridSerenitywithTestSuite() {
		super();
		String dirPath = System.getProperty("user.dir");
		/*
		 * getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.
		 * WEBDRIVER_REMOTE_URL.getPropertyName(),
		 * "http://localhost:4444/wd/hub");
		 */
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(), "browserName:chrome");

		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_STORE_HTML_SOURCE.getPropertyName(),
				"true");
		/*
		 * getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.
		 * THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName(), "/tooSee/serenity2");
		 */
		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName(),
				dirPath + "/target/site/serenity/");
		/*
		 * getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.
		 * THUCYDIDES_TAKE_SCREENSHOTS.getPropertyName(), "FOR_FAILURES");
		 */
	}

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("stories/GoogleSearch2.story");
	}

	@Override
	public void run() throws Throwable {
		super.run();
	}
}
