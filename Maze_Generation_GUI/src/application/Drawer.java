package application;

import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;

public class Drawer {

	private static int n = 0;
	private static Cell[][] board = null;
	
//	public static void startDrawing()
//	{
//		createBoard();
//		
//		//needs to be connected to algorithm in some way; does the algorithm call draw or does this Drawer get information continuously from
//		//algorithm; like a flag that is true while the algorithm is working, and the drawer will keep drawing? Or should this Drawer not know
//		//about the algorithm?
//		
//		draw();
//	}
//	
//	private static void createBoard()
//	{
//		//n must be an odd number
//		board = new Cell[n][n];
//		
//		for(int i = 0; i < n; ++i)	//put new cells in board
//		{
//			for(int j = 0; j < n; j++)
//			{
//				board[i][j] = new Cell(i, j, n);
//			}
//		}	
//		//call algorithm which will continuously call the update method		
//	}
	
	public static void draw() 
	{
			
			//loops through cells, if cell is 0 then paint black, if 1 then white.
		
			for(int i = 0; i < board.length - 1; i++)	
			{
					for(int j = 0; j < board.length - 1; j++)
					{
						if(board[i][j].state == 0)
						{	
							View.getGraphicsContext().setFill(Color.BLACK);
							View.getGraphicsContext().fillRect(board[i][j].X, board[i][j].Y, Cell.CELL_WIDTH, Cell.CELL_HEIGHT );
						
						}
						else
						{
							View.getGraphicsContext().setFill(Color.WHITE);
							View.getGraphicsContext().fillRect(board[i][j].X, board[i][j].Y, Cell.CELL_WIDTH, Cell.CELL_HEIGHT );
						
						}	
					 						
					}
			}
			
//			long mStartTime = System.currentTimeMillis();
//			boolean done = false;
//			
//			while(!done) {
//				if( (System.currentTimeMillis() - mStartTime) > 100000){
//				    done = true;
//				}
//			}
			
			//TimeUnit.SECONDS.sleep(1);
			
//			 try {
//			        Thread.sleep(20);
//			    } catch (InterruptedException reallyIgnored) {}
	}
	
	public static void setN(int value)
	{
		n = value;
	}
	
	public static void setBoard(Cell[][] boardArray)
	{
		board = boardArray;
	}
	

//	@FXML
//	private void randomizeStates() {
//		Random random = new Random(System.currentTimeMillis());
//		
//		for(int i = 0; i < n; ++i)	
//			for(int j = 0; j < n; j++)
//				board[i][j].state = random.nextInt(2);
//		
//	}

}
