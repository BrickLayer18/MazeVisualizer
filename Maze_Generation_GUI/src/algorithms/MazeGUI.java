package algorithms;
import javax.swing.*;
import java.awt.*;
public class MazeGUI extends JPanel
{
	public void paint(Graphics g)
	{
		g.fillRect(100, 100, 400, 400);
		g.clearRect(100, 100, 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(100, 100, 50, 50);
		g.setColor(Color.RED);
		g.fillRect(200, 100, 100, 50);
	}
	
	public static void makeBoard()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Maze Visualizer");
		frame.setSize(600, 600);
		frame.getContentPane().add(new MazeGUI());
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		MazeGUI.makeBoard();
	}
}
