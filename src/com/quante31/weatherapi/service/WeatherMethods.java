package com.quante31.weatherapi.service;

import java.io.IOException;
import java.net.URISyntaxException;

import com.quante31.weatherapi.model.Limit;
import com.quante31.weatherapi.model.Location;


public interface WeatherMethods {
	String getWeather(int lat, int lot, String apiKey, String units) throws URISyntaxException, IOException, InterruptedException;
	
	String getCoordinatesByLocation(Location location, Limit l, String apiKey) throws URISyntaxException, IOException, InterruptedException;
}
