module WeatherGUI {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires jdk.jsobject;
	requires java.net.http;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	
	opens com.quante31.weatherapi.model to com.fasterxml.jackson.databind;
	opens com.quante31.weatherapi.gui to javafx.graphics, javafx.fxml;
}
