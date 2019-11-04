package algorithms;
import java.util.Random;

import application.Cell;

public class BushmanMaze extends Maze
{
	public BushmanMaze(int length, int clock, boolean printBoard)
	{
		super.printBoard = printBoard;
		super.length = length;
		super.clock = clock;
		board = new Cell[length][length];
		rand = new Random();		
		initBoard();	
	}

	@Override
	public void generateMaze() 
	{		
		int x = 0;
		int y = 0;
		int px = 0;
		int py = 0;
		board[0][0].state = 0;
		while(y < length)
		{
			char dir = getValidDir(x, y);
			while(dir != ' ')
			{
				switch(dir)
				{
					case 'U':
						board[x][y-1].state = 0;
						board[x][y-=2].state = 0;
						printMaze();
						break;
					case 'D':
						board[x][y+1].state = 0;
						board[x][y+=2].state = 0;
						printMaze();
						break;
					case 'L':
						board[x-1][y].state = 0;
						board[x-=2][y].state = 0;
						printMaze();
						break;
					case 'R':
						board[x+1][y].state = 0;
						board[x+=2][y].state = 0;
						printMaze();
						break;				
				}
				dir = getValidDir(x, y);
			}
			
			if(getValidDir(px, py) == ' ')
				if(px+1 == length)
				{
					px = 0;
					py += 2;
				}
				else
					px+=2;				
			x = px;
			y = py;		
		}		
		printMaze();		
	}
}
