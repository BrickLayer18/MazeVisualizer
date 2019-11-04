package algorithms;
import java.util.ArrayList;
import java.util.Random;

import application.Cell;

public class PrimMaze extends Maze
{	
	private ArrayList<Coord> cellPositions;	
	public PrimMaze(int length, int clock, boolean printBoard)
	{
		super.printBoard = printBoard;
		super.length = length;
		super.clock = clock;
		cellPositions = new ArrayList<Coord>(length/2); 
		board = new Cell[length][length];
		rand = new Random();		
		initBoard();	
	}
	
	public void generateMaze()
	{
		startingX = generateRandomStartingIndex();
		startingY = generateRandomStartingIndex();
		board[startingX][startingY].state = 0;
		printMaze();
		makeMaze(startingX, startingY);
	}
	
	private void makeMaze(int x, int y)
	{	
		cellPositions.add(new Coord(x, y));
		int ndx;
		int curX = 0;
		int curY = 0;
		Coord coord;		
		while(!cellPositions.isEmpty())
		{
			ndx = rand.nextInt(cellPositions.size());
			coord = cellPositions.get(ndx);
		    curX = coord.X;
			curY = coord.Y;
			switch(getValidDir(curX,curY))//dir)
			{
				case 'U':						
					board[curX][curY-1].state = 0;
					board[curX][curY-2].state = 0;
					printMaze();
					cellPositions.add(new Coord(curX, curY-2));
					break;
					
				case 'D':						
					board[curX][curY+1].state = 0;
					board[curX][curY+2].state = 0;
					printMaze();
					cellPositions.add(new Coord(curX, curY+2));					
					break;
				
				case 'L':
					board[curX-1][curY].state = 0;
					board[curX-2][curY].state = 0;
					printMaze();
					cellPositions.add(new Coord(curX-2, curY));	
					break;
					
				case 'R':													
					board[curX+1][curY].state = 0;
					board[curX+2][curY].state = 0;
					printMaze();
					cellPositions.add(new Coord(curX+2, curY));								
					break;	
				
				default:
					cellPositions.set(ndx, cellPositions.get(cellPositions.size()-1));
					cellPositions.remove(cellPositions.size()-1);
					break;
			}
				
		}
	}
}
