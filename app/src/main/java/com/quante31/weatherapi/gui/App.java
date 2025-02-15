package com.quante31.weatherapi.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root);
			String css = this.getClass().getResource("/application.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setScene(scene);
			stage.show();
			stage.setResizable(false);
			Image icon = new Image("/cloudy.png");
			stage.getIcons().add(icon);
			stage.setTitle("OpenWeather API Program");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to exit");
		alert.setContentText("Are you sure you want to exit? ");

		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("You've successfully logged out!");
			stage.close();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
