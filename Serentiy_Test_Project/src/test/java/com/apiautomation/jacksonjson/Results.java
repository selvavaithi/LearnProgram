package com.apiautomation.jacksonjson;

public class Results {
	private String partial_match;

	private String place_id;

	private Address_components[] address_components;

	private String formatted_address;

	private String[] types;

	private Geometry geometry;

	public String getPartial_match() {
		return partial_match;
	}

	public void setPartial_match(String partial_match) {
		this.partial_match = partial_match;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public Address_components[] getAddress_components() {
		return address_components;
	}

	public void setAddress_components(Address_components[] address_components) {
		this.address_components = address_components;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "ClassPojo [partial_match = " + partial_match + ", place_id = " + place_id + ", address_components = "
				+ address_components + ", formatted_address = " + formatted_address + ", types = " + types
				+ ", geometry = " + geometry + "]";
	}
}
