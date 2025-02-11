package com.quante31.weatherapi.service;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpWeatherRequestBuilder{
	
	private HttpRequest.Builder requestBuilder;
	
	public HttpWeatherRequestBuilder() {
		
	}
	
	public HttpWeatherRequestBuilder(URI uri) {
		this.requestBuilder = HttpRequest.newBuilder(uri);
	}
	public HttpRequest.Builder getRequestBuilder(){
		return requestBuilder;
	}
	
	


	

}
