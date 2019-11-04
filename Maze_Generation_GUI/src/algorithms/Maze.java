package algorithms;
import java.util.Random;
import application.*;

import application.Drawer;
public abstract class Maze 
{
	//Starting positions of maze
	protected int startingY, startingX;
	//Will give random numbers when needed
	protected Random rand;
	//The maze board
	protected Cell[][] board;
	//The length of a side of the square board
	protected int length;
	//How fast the board will print
	protected int clock;
	
	protected char[] directions = {'L', 'R', 'U', 'D', ' '};
	//An array of different directions represented with chars
	
	//int num = 0;
	
	protected boolean printBoard;
	
	/**
	 * Loads a blank board with black cells
	 */
	protected void initBoard()
	{
		for(int i = 0; i < length; ++i)
			for(int j = 0; j < length; ++j)
				board[i][j] = new Cell(i, j, length);		
	}

	/**
	 * Prints the maze 
	 */
	public void printMaze()
	{
		//call upon draw(board);
			Drawer.setBoard(board);
		
		//Delay Timer
//		try        
//		{ Thread.sleep(clock); }
//		catch(InterruptedException ex)
//		{ Thread.currentThread().interrupt(); }
		
		//System.out.println(this + "\n");
		
		
		
	}
	
	/**
	 * Will return a valid random starting position
	 * @return a random valid starting position
	 */
	protected int generateRandomStartingIndex()
	{
		return 2*rand.nextInt((length/2)+1);		
	}
	
	/**
	 * Will generate a maze 
	 */
	protected abstract void generateMaze();
	
	/**
	 * Will return a random direction that points in an area that has not yet been visited,
	 * @param x The x coordinate on the board
	 * @param y The y coordinate on the board
	 * @return A direction that points to an area that has yet to be visited
	 */
	protected char getValidDir(int x, int y)
	{
		char dir = ' ';
		int ndx = 0;
		int i = 4;
		while(i > 0)
		{
			ndx = rand.nextInt(i);
			dir = directions[ndx];
			if(isValid(x,y,dir))
				return dir;
			directions[4] = directions[ndx];
			directions[ndx] = directions[--i];
			directions[i] = directions[4];
		}
		//++num;
		return ' ';
	}
	
	private boolean isValid(int x, int y, char dir)
	{
		boolean valid = false;
		switch (dir)
		{
			case 'U':				
				valid = (y != 0) && (board[x][y-2].state == 1);
				break;
				
			case 'D':
				valid = (y != length-1) && (board[x][y+2].state == 1);
				break;
				
			case 'L':
				valid = (x != 0) && (board[x-2][y].state == 1);
				break;
				
			case 'R':
				valid = (x != length-1) && (board[x+2][y].state == 1);
				break;
		}
		return valid;
	}
	
	protected boolean outOfBounds(int x, int y, char dir)
	{
		boolean valid = false;
		switch (dir)
		{
			case 'U':				
				valid = (y == 0);
				break;
				
			case 'D':
				valid = (y == length-1);
				break;
				
			case 'L':
				valid = (x == 0);
				break;
				
			case 'R':
				valid = (x == length-1);
				break;
		}
		return valid;
	}
	
	public String toString()
	{
		String s = "1 1";
		String row = "";
		for(int i = 0; i < length; ++i)
			row += " 1";
		s += row + "\n";
		for(int j = 0; j < length; j++)
		{
			s += "1 ";
			for(int i = 0; i < length; i++)
				s += (board[i][j].state + " " );
			s += "1 ";
			s += "\n";
		}
		s += "1 1" + row;
		
		/*
		s+="\n\n";		
		s += "1\t1";
		row = "";
		for(int i = 0; i < length; ++i)
			row += "\t1";
		s += row + "\n";
		for(int j = 0; j < length; j++)
		{
			s += "1\t";
			for(int i = 0; i < length; i++)
				s += (board[i][j].treeVal + "\t" );
			s += "1\t";
			s += "\n";
		}
		s += "1\t1" + row;
		*/
		
		
		return s;		
	}
	
	
}
