package application;

import java.io.IOException;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View 
{
	public static Pane root; 
	public static Stage stage; 
	public static GraphicsContext gc;
	public static Canvas canvas = new Canvas(400, 400);
	public static Scene scene;
	
	//The controls of the GUI:
	
	@FXML
	public TextArea widthHeightValueBox; 
	
	@FXML
	public Slider scrollBar;
	
	@FXML
	public static ChoiceBox<String> algorithmChoiceBox;
	@FXML
	public static Button startButton;
	@FXML
	public static Button pauseButton;
	@FXML
	public static Button clearButton;
	
	
	public void setUp(Stage primaryStage) throws IOException 
	{
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("Main.fxml"));
		
	//	root = FXMLLoader.load(View.class.getResource("Main.fxml"));
//		
		//root = loader.load();
	
		Map<String, Object> fxmlNamespace = loader.getNamespace();
		scrollBar = (Slider) fxmlNamespace.get("scrollBar");
		
		
		gc = canvas.getGraphicsContext2D();	
		root.getChildren().add(canvas);
		
		scene = new Scene(root,500,500, Color.WHITE) ;
		stage = primaryStage; 
	    stage.setTitle("mazegen");
	    stage.setScene(scene);
	    stage.show();
	    
	    setUpAlgorithmChoiceBox();
	}
	
	private static void setUpAlgorithmChoiceBox()
	{
		
	}
	
	@FXML
	private void startButtonClicked()
	{
		Controller.start();
	}
	
	@FXML
	private void pauseButtonClicked()
	{	
		//Controller.pause();
	}
	
	@FXML
	private void clearButtonClicked()
	{
		//Controller.clear();
		System.out.println("clicked");
	}
	
	@FXML
	public void dragDoneOnSlider()
	{
		System.out.println("dragged");
		Controller.setN(this);
	}
	
	//getters
	
	public static GraphicsContext getGraphicsContext()
	{
		return gc;
	}
	
	public double getScrollBarValue()
	{
		return scrollBar.getValue();
	}
		
	public void writeToWidthHeightValueBox(String text)
	{
		System.out.println("working");
		widthHeightValueBox.setText("");
		widthHeightValueBox.setText(text);
	}

	
}
