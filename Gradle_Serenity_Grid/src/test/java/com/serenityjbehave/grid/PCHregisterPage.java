package com.serenityjbehave.grid;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;

public class PCHregisterPage extends SerenityStories {
	
	@Override
	public List<String> storyPaths() {
		return Arrays.asList("stories/pch.story");
	}

}
