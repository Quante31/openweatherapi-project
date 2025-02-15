package com.quante31.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
	@JsonProperty("1h")
	private int oneh;

	public int getOneh() {
		return oneh;
	}

	public void setOneh(int oneh) {
		this.oneh = oneh;
	}
	
}
