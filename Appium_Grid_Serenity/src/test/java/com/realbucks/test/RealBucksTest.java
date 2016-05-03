package com.realbucks.test;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;

public class RealBucksTest extends SerenityStories {

	@Override
	public List<String> storyPaths() {
		return Arrays.asList("Stories/RealBucksStories/realbuckstory.story");
	}

}
