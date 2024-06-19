package com.quante31.weatherapi.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.quante31.weatherapi.model.*;

public class Main {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		WeatherService weatherService = new WeatherService();
		weatherService.setAPIKey("OpenWeatherAPIkey");
		
		Location location = new Location();
		location.setCityName("England");
		
		Limit limit = new Limit("3");
		
		String coordinatesJson = weatherService.getCoordinatesByLocation(location, limit, weatherService.getAPIKey());
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<Coordinates> coordinates = objectMapper.readValue(coordinatesJson,new TypeReference<List<Coordinates>>() {});
		
		for (Coordinates coordinate : coordinates) {
			String weatherInfoJson = weatherService.getWeather(coordinate.getLat(), coordinate.getLon(), weatherService.getAPIKey(),"metric");
			WeatherGlobal weatherInfo = objectMapper.readValue(weatherInfoJson, WeatherGlobal.class);
			System.out.println(weatherInfo.getName());
			System.out.println(weatherInfo.getMain().getTemp());
		}
		
	}
}
