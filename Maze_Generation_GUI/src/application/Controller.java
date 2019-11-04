package application;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

import algorithms.BushmanMaze;
import algorithms.Driver;
import algorithms.Maze;

public class Controller {

	Drawer drawer;
	
    public static void setN(View view)
    {
    	//get the data from the scroll control to get a value for n
    	//also adjust the canvas to be big enough (done in the creation of the cells)
    	System.out.println("hi");
		int scrollBarValue = (int) view.getScrollBarValue();
		
		scrollBarValue = (scrollBarValue % 2 == 0) ? scrollBarValue + 1 : scrollBarValue;
		
		Drawer.setN(scrollBarValue);
		
		view.writeToWidthHeightValueBox("" + scrollBarValue);
    }
	

	@FXML
	public static void start() 
	{
		//disable start button
		//change text of start button to resume
		//disable scroll bar
		//disable choice box thing
		//disable clear
		
		//instantiate maze based on selection scroll
		//Maze maze = new BushmanMaze(7, 00, true);
		
		new BushmanMaze(31, 0, true).generateMaze();
		
		//final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    //executorService.scheduleWithFixedDelay(Drawer::draw, 0, 5, TimeUnit.SECONDS);
	    
		 Thread updateThread = new Thread() {
	         @Override
	         public void run() {
	            while (true) {
	               Drawer.draw();   
	                  // Delay and give other thread a chance to run
	           
	               try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
	         }
	         }
	      };
	      updateThread.start(); // called back run()
	 
	 
	}
	
	public static void pause()
	{
		//enable start/resume button
		
		
		//pause program
		//Drawer.pauseDrawing();
	}
	
	
	@FXML
	public static void clear() 
	{
		//enable start button
		//change text of start button to start
		//enable scroll bar
		//enable choice box thing
		//enable clear
				
		View.getGraphicsContext().setFill(Color.WHITE);
		View.getGraphicsContext().fillRect(0, 0, 400, 400);
		
		//reset all defaults
	}
	
}
