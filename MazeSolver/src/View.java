import java.awt.Color;
import java.awt.Graphics;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class View extends JFrame{
	
	private List <Integer> path = new ArrayList<Integer>();
	
	private static int[][] maze;
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
	

	
	

	
		
	public View() {
		setTitle("Maze Solver");
		setSize(1390, 610);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		SearchAlgorithm.search(maze, 1, 1, path);
		//System.out.println(path);
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
		
		final int ps = path.size()-2;
		//print the final path
		for(int p = 0; p<path.size(); p+=2) {
			
			
			int pathX = path.get(p);
			int pathY = path.get(p+1);
			
			
			if (p == 0) {//final position
				g.setColor(Color.RED);
			} else if (p == ps) {//starting position
				g.setColor(Color.BLUE);
			} else {	//normal path
				g.setColor(Color.GREEN);
			}
			
			
			g.fillRect(30 * pathX, 30*pathY, 30	, 30);
			
		}
		
	}
	
	public static void main(String[] args) {
		//reads the maze from a JSON file
		try {
			
			//json data file localization and file name
			String file = new String("maze.json");
			
			JSONParser parser = new JSONParser();

			//obtains the jsonfile
			Object obj = parser.parse(new FileReader(file));
		
			
			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
			JSONObject jsonObject = (JSONObject) obj;
			
			//obtains the number of collumns and rows
			int columns = (int) (long) jsonObject.get("NColumns");	
			int rows = (int) (long) jsonObject.get("NRows");
			
			// A JSON array.
			JSONArray MazeJSONArray = (JSONArray) jsonObject.get("Maze");
			
			maze = new int[rows][columns];
			
			
			for(int i=0; i<rows; i++) {
				JSONArray MazeJSONArrayHelper = (JSONArray) MazeJSONArray.get(i);
				
				for(int n =0; n<columns; n++) {

					maze[i][n] = (int) (long) MazeJSONArrayHelper.get(n);

				}
			}
			 
			
			/*
			 * for (int i =0; i< rows; i++) {
				int [] ok = (int) MazeJSONArray.get(i); 
			}
			*/
			
			
		}catch(Exception e) {
			System.out.println("Error: Json file error");
			e.printStackTrace();
		}
		
		
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				View view = new View();
				view.setVisible(true);
				
				
			}
			
		});
	}
	
	
			
}




























