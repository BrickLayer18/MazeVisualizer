package algorithms;

public class Coord	
{
	final int X;
	final int Y;
	public Coord(int x, int y)
	{
		X = x;
		Y = y;
	}
	
	public String toString()
	{
		return "(" + X + ", " + Y + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Coord))	
			return false;
		Coord coord = (Coord) obj;
		return coord.X == X && coord.Y == Y;
	}
	
	public int hashCode()
	{
		int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}
}