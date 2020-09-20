import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class View extends JFrame{
	
	
	/*this two dimensional array represnets the "map"
	*
	*
	*Values:
	*0- not visited node
	*1- wall
	*2-visited node
	*9- target
	*
	*start position as (1,1)
	*end position: (11,8)
	*/
	
	
	
	
	private int maze[][] = 
			{ {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			  {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1,0,0,0,1,0,1,0,1,0,0,1},
			  {1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1},
			  {1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,1},
			  {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,0,1,1},
			  {1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,1},
			  {1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1},
			  {1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1},
			  {1,1,1,1,1,1,0,0,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			  {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,1,1,1},
			  {1,0,1,1,1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1},
			  {1,0,0,1,1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,1,0,1,0,1,1,1,0,1},
			  {1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,1},
			  {1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,0,0,0,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1},
			  {1,1,1,1,1,0,0,0,1,0,0,0,0,1,1,0,1,1,1,1,1,9,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1,1,1,1},
			  {1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1},
			  {1,0,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1},
			  {1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
			  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
			  
			};
	private List <Integer> path = new ArrayList<Integer>();
		
	public View() {
		setTitle("Maze Solver");
		setSize(1390, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		SearchAlgorithm.search(maze, 1, 1, path);
		System.out.println(path);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.translate(0, 30);
		
		//draw the maze
		for(int row =0; row < maze.length; row++) {
			for(int col =0; col < maze[0].length; col++) {
				Color color;
				
				
				//decides the color based on the object
				switch(maze[row][col]) {
				case 1:
					color = Color.BLACK;
					break;	
				case 9:
					color = Color.RED;
					break;
				default:
					color = Color.WHITE;
					break;
				}
				g.setColor(color);
				g.fillRect(30 * col, 30*row, 30	, 30);
				g.setColor(Color.BLACK);
				g.drawRect(30 * col, 30*row, 30	, 30);
				
			}
		}
		
		//print the final path
		for(int p = 0; p<path.size(); p+=2) {
			
			
			int pathX = path.get(p);
			int pathY = path.get(p+1);
			
			if(p==0)
			{
				g.setColor(Color.RED);
				
			}else {
				g.setColor(Color.GREEN);
			
			}
			
			g.fillRect(30 * pathX, 30*pathY, 30	, 30);
			
		}
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				View view = new View();
				view.setVisible(true);
				
				
			}
			
		});
	}
	
	
			
}




























