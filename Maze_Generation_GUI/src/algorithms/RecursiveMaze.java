package algorithms;
import java.util.Random;

import application.Cell;
public class RecursiveMaze extends Maze
{	
	/**
	 * Creates a blank board of length length
	 * @param length The square length of the maze board. Minimum 
	 * length is 5 and must be odd. Max recommended length is 201
	 * @param clock Time in between each time the board is printed 
	 */
	public RecursiveMaze(int length, int clock, boolean printBoard)
	{		
		super.printBoard = printBoard;
		this.length = length;
		this.clock = clock;
		rand = new Random();
		board = new Cell[length][length];
		initBoard();			
	}
	
	/**
	 * Will randomly create a starting position for a maze and will begin 
	 * to generate the maze
	 */
	public void generateMaze()
	{
		startingX = generateRandomStartingIndex();
		startingY = generateRandomStartingIndex();
		board[startingX][startingY].state = 0;
		makeMaze(startingX, startingY);
		//printMaze();
	}
	
	/**
	 * Will generate a maze segment starting at x, y
	 * @param x The starting x coordinate of a segment
	 * @param y The starting y coordinate of a segment
	 */
	private void makeMaze(int x, int y)
	{
		char dir = getValidDir(x, y);
		while(dir != ' ')
		{
			switch(dir)
			{
				case 'U':
					board[x][y-1].state = 0;
					board[x][y-2].state = 0;
					//printMaze();
					makeMaze(x, y-2);
					break;
				case 'D':
					board[x][y+1].state = 0;
					board[x][y+2].state = 0;
					//printMaze();
					makeMaze(x, y+2);
					break;
				case 'L':
					board[x-1][y].state = 0;
					board[x-2][y].state = 0;
					//printMaze();
					makeMaze(x-2, y);
					break;
				case 'R':
					board[x+1][y].state = 0;
					board[x+2][y].state = 0;
					//printMaze();
					makeMaze(x+2, y);
					break;				
			}
			dir = getValidDir(x,y);
		}
	}
}
