package com.quante31.weatherapi.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.quante31.weatherapi.model.*;

public class WeatherService implements WeatherMethods{
	private String APIKey;
	
	public WeatherService(String apiKey) {
		this.APIKey = apiKey;
	}
	
	public WeatherService() {

	}
	
	public void setAPIKey(String apiKey) {
		this.APIKey = apiKey;
	}
	
	public String getAPIKey() {
		return APIKey;
	}
	@Override
	public String getWeather(int lat, int lon, String apiKey, String units) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest.Builder requestBuilder = new HttpWeatherRequestBuilder(new URI("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon="+ lon +"&appid=" + apiKey + "&units=" + units)).getRequestBuilder();
		requestBuilder.GET();
		HttpRequest request = requestBuilder.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}
	@Override
	public String getCoordinatesByLocation(Location location, Limit l, String apiKey) throws URISyntaxException, IOException, InterruptedException {
		String fullLocation = location.getFullLocation();
		String limit = l.getLimit();
		HttpRequest.Builder requestBuilder = new HttpWeatherRequestBuilder(new URI("http://api.openweathermap.org/geo/1.0/direct?q=" + fullLocation + "&limit=" + limit + "&appid=" + apiKey)).getRequestBuilder();
		requestBuilder.GET();
		HttpRequest request = requestBuilder.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}

	

}
