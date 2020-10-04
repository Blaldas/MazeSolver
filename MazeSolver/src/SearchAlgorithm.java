import java.util.List;

public class SearchAlgorithm {

	/*
	 * finds a path:
	 * 
	 * return true: path found
	 * return false: path not found
	 * 
	 * if a path is found, it is recorded in the List path
	 * the organization of the list is based on the following example:
	 * x1,y1,x2,y2,x3,y3...
	 * 
	 * the recived values (arguments) X and Y represent the searching position
	 */
	public static boolean search(int [][] maze, int x, int y, List<Integer> path) {
		
		//break of the recursive calls
		//case finds the objective
		if(maze[y][x] == 9) {
			path.add(x);
			path.add(y);
			return true;
		}
		
		//this if guarantees that is it neither a wall nor a place where has already passed
		if(maze[y][x] == 0) {
			maze[y][x] = 2;
		
		
			//right
			if(search(maze, x +1, y, path)) {
				path.add(x);
				path.add(y);
				return true;
			}
			
			//left
			if(search(maze, x -1, y, path)) {
				path.add(x);
				path.add(y);
				return true;
			}
			
			//upwards
			if(search(maze, x, y +1, path)) {
				path.add(x);
				path.add(y);
				return true;
			}
			
			//downwards
			if(search(maze, x, y -1, path)) {
				path.add(x);
				path.add(y);
				return true;
			}
			
		
		}
		
		
		//"default"
		return false;
	}
	
	
}
