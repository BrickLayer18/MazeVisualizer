package application;
import algorithms.*;
	
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Main extends Application implements Initializable
{
	public static void main(String[] args) 
	{
		launch(args);		
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		try 
		{			
			(new View()).setUp(primaryStage);	
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	
		
	}
		  	
}
