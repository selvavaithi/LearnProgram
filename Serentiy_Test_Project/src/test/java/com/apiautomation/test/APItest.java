package com.apiautomation.test;

import java.util.Arrays;
import java.util.List;
import net.serenitybdd.jbehave.SerenityStories;

public class APItest extends SerenityStories {

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("Stories/APItest.story");
	}

}
