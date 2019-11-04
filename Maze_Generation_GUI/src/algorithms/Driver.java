package algorithms;


public class Driver 
{
	public static void startMazeDriver(Maze maze) throws InterruptedException
	{		
		Maze m = maze;
				
				//new KruskalMaze(7, 00, true);
		//long time = System.nanoTime();		
		m.generateMaze();
		m.printMaze();
		//System.out.println(m.num);
		//m.printMaze();
		//System.out.println("Time it took: " + (System.nanoTime() - time)/1000000 + "\n");
		//m.printMaze();
		
		//m.printMaze();
		/*
		System.out.println("Bushman maze");
		long time = System.nanoTime();		
		m.generateMaze();
		System.out.println("Time it took: " + (System.nanoTime() - time)/1000000 + "\n");
		m = new RecursiveMaze(11, 0, true);
		System.out.println("Recursive maze");
		time = System.nanoTime();		
		m.generateMaze();
		System.out.println("Time it took: " + (System.nanoTime() - time)/1000000);
		*/
	}
	
	public static boolean isValidMaze()
	{
		
		return true;
	}
}
