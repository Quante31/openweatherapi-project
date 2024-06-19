package com.quante31.weatherapi.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
	
	private String name;
	
    @JsonProperty("local_names")
	private Map<String,String> localNames;
    
	private int lat;
	private int lon;
	private String country;
	private String state;
	
	public Coordinates() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLon() {
		return lon;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Map<String, String> getLocalNames() { 
		return localNames; 
	}
	
    public void setLocalNames(Map<String, String> localNames) {
    	this.localNames = localNames; 
    }

}
