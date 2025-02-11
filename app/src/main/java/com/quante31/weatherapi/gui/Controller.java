package com.quante31.weatherapi.gui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quante31.weatherapi.model.Coordinates;
import com.quante31.weatherapi.model.Limit;
import com.quante31.weatherapi.model.Location;
import com.quante31.weatherapi.model.WeatherGlobal;
import com.quante31.weatherapi.service.WeatherService;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
	@FXML
	private Button getWeatherButton;
	@FXML
	private TextArea outputTextArea;
	@FXML
	private TextField cityTextField;
	@FXML
	private ChoiceBox<String> formatChoiceBox;
	
	String[] formats = {"City, description, temperature, clouds", 
						"City, description, temperature, wind", 
						"City, description, temperature, visibility",
						"City, description, temperature, humidity",
						"City, description, temperature, pressure",
						"City, longitude, latitude, humidity, pressure, visibility, clouds, wind"
	};
	
	Stage stage;
	
	public void getWeather(ActionEvent e) throws URISyntaxException, IOException, InterruptedException {
		String format = formatChoiceBox.getValue();
		
		if (format == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No weather output format has been chosen");
			alert.setContentText("Please choose a format");
			alert.showAndWait();
			return;
		}
		if (cityTextField.getText() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No city has been written, please write a city.");
			alert.setContentText("No city error");
			alert.showAndWait();
			return;
		}
		String outputWeather = parseWeather(format);
		String previousText = outputTextArea.getText();
		outputTextArea.setText(previousText + outputWeather);

	}
	private String parseWeather(String format) throws URISyntaxException, IOException, InterruptedException {
		WeatherService weatherService = new WeatherService();
		weatherService.setAPIKey("API KEY");
		
		Location location = new Location();
		location.setCityName(cityTextField.getText());
		
		Limit limit = new Limit("1");
		
		String coordinatesJson = weatherService.getCoordinatesByLocation(location, limit, weatherService.getAPIKey());
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<Coordinates> coordinates = objectMapper.readValue(coordinatesJson,new TypeReference<List<Coordinates>>() {});
		String output = "";
		for (Coordinates coordinate : coordinates) {
			String weatherInfoJson = weatherService.getWeather(coordinate.getLat(), coordinate.getLon(), weatherService.getAPIKey(),"metric");
			WeatherGlobal weatherInfo = objectMapper.readValue(weatherInfoJson, WeatherGlobal.class);

			if (format == formats[0]) {
				output = cityTextField.getText() + ", " + weatherInfo.getWeather().get(0).getDescription() + ", " + weatherInfo.getMain().getTemp() + ", " + weatherInfo.getClouds().getAll();
			}
			else if (format == formats[1]) {
				output = cityTextField.getText() + ", " + weatherInfo.getWeather().get(0).getDescription() + ", " + weatherInfo.getMain().getTemp() + ", " + weatherInfo.getWind().getSpeed();
			}
			else if (format == formats[2]) {
				output = cityTextField.getText() + ", " + weatherInfo.getWeather().get(0).getDescription() + ", " + weatherInfo.getMain().getTemp() + ", " + weatherInfo.getVisibility();
			}
			else if (format == formats[3]) {
				output = cityTextField.getText() + ", " + weatherInfo.getWeather().get(0).getDescription() + ", " + weatherInfo.getMain().getTemp() + ", " + weatherInfo.getMain().getHumidity();
			}
			else if (format == formats[4]) {
				output = cityTextField.getText() + ", " + weatherInfo.getWeather().get(0).getDescription() + ", " + weatherInfo.getMain().getTemp() + ", " + weatherInfo.getMain().getPressure();
			}
			else if (format == formats[5]) {
				output = cityTextField.getText() + ", " + weatherInfo.getCoord().getLon() + ", " + weatherInfo.getCoord().getLat() + ", " + weatherInfo.getMain().getHumidity() + ", " + weatherInfo.getMain().getPressure() + ", " + weatherInfo.getVisibility() + ", " + weatherInfo.getClouds().getAll() + ", " + weatherInfo.getWind().getSpeed();
			}
			
		}
		return output + "\n";
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		formatChoiceBox.getItems().addAll(formats);	
	}


}
