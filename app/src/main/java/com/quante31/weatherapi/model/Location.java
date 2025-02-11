package com.quante31.weatherapi.model;

public class Location {
	private String cityName;
	
	private String stateCode;
	
	private String countryCode;
	
	public Location() {
		
	}
	
	public Location(String cityname, String statecode, String countrycode) {
		this.setCityName(cityname);
		this.setStateCode(statecode);
		this.setCountryCode(countrycode);
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityname) {
		this.cityName = cityname;
	}
	
	public boolean isCityNamePresent() {
		return (this.cityName != null);
	}
	
	public String getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(String statecode) {
		this.stateCode = statecode;
	}

	public boolean isStateCodePresent() {
		return (this.stateCode != null);
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countrycode) {
		this.countryCode = countrycode;
	}
	
	public boolean isCountryCodePresent() {
		return (this.countryCode != null);
	}
	
	public String getFullLocation() {
		String fullLocation = "";
		if (this.isCityNamePresent()) {
			fullLocation += getCityName();
		}
		if (this.isStateCodePresent()) {
			fullLocation += "," + getStateCode();
		}
		if (this.isCountryCodePresent()) {
			fullLocation += "," + getCountryCode();
		}
		return fullLocation;
	}
}
