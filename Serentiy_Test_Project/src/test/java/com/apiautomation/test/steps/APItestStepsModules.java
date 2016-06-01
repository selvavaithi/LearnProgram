package com.apiautomation.test.steps;

import com.apiautomation.test.pageobject.APItestpageObjects;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

public class APItestStepsModules {
	@ManagedPages
	APItestpageObjects apitestpageobjects;

	@Step
	public void getAddressOfstr(String str) {
		apitestpageobjects.jacksonJSON_Geocoding(str);
	}

	@Step
	public void getAddressofNearBy(String nearby, String area) {
		apitestpageobjects.getNearByPlacesFor(nearby, area);
	}

	public void printNearByCoordinates(String area, String nearby) {
		apitestpageobjects.printCoordinatesfor(area, nearby);
	}

}
