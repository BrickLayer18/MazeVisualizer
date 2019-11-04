package application;

public class Cell 
{
	static int CELL_WIDTH;
	static int CELL_HEIGHT;
	final int X;	//The X coordinate of this Cell
	final int Y;	//The Y coordinate of this Cell
	public int state;		//The state of this Cell
	
	public Cell(int X, int Y, int n)
	{		
		this.X = X*1000/n;
		this.Y = Y*1000/n;
		
		CELL_WIDTH = 1000/n;
		CELL_HEIGHT = 1000/n;
		
		state = 1;		//can either be white (1) or black (0)
	}	
	
	/**
	 * Compares two cells and returns true iff they have
	 * the same x and y coordinates.
	 */
	public boolean equals(Object obj)
	{
		Cell cell = (Cell) obj;
		return cell.X == X && cell.Y == Y;
	}	
	
	/**
	 * @return A String representation of the coordinates of this Cell
	 */
	public String printCoord()
	{
		return "(" + X + ", " + Y + ")";
	}
	
	/**
	 * Returns a String representation of this Cell based on its value
	 */
	public String toString()
	{
		return "" + state;//directions.toString();
	}
}