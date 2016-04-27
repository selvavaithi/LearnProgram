package com.test.serenitygrid.GridSerenityProcess;

import java.util.Arrays;
import java.util.List;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.ThucydidesSystemProperty;

public class GridSerenityProcessTestSuite extends SerenityStories {

	public GridSerenityProcessTestSuite() {
		super();
		/*
		 * getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.
		 * WEBDRIVER_REMOTE_URL.getPropertyName(),
		 * "http://localhost:4444/wd/hub");
		 */
		
		getSystemConfiguration().setIfUndefined(
				ThucydidesSystemProperty.THUCYDIDES_DRIVER_CAPABILITIES.getPropertyName(), "browserName:firefox");

		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_STORE_HTML_SOURCE.getPropertyName(),
				"true");

		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName(),
				"https://github.com/");

		/*
		 * getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.
		 * THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName(),
		 * "/myResult/serenity1");
		 */

		getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_OUTPUT_DIRECTORY.getPropertyName(),
				"D:/WorkSpace/MarsWorkSpace/GridSerenityProcess/target/site/serenity/");

		/*
		 * getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.
		 * THUCYDIDES_TAKE_SCREENSHOTS.getPropertyName(), "FOR_FAILURES");
		 */
	}

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("stories/GoogleSearch.story");
	}

	@Override
	public void run() throws Throwable {
		super.run();
	}

}
