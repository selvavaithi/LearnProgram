package saucelab.test;

import java.util.Arrays;
import java.util.List;
import net.serenitybdd.jbehave.SerenityStories;

public class SerenitySaucelabTest extends SerenityStories {

	@Override
	public List<String> storyPaths() {

		return Arrays.asList("Stories/SampleAppStories/simpleapp.story");
	}

}