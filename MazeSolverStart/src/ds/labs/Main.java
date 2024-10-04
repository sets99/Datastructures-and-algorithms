package ds.labs;
public class Main {

	public static void main(String[] args) {
		
	
		MazeSolver solver = new MazeSolver();

		
		// Eventually try to solve all 4 mazes 
		solver.loadMaze("Maze2.txt");
		
		
		//print out maze as you go
		//solver.solve(true);
		
		//do not print out maze as you go
		solver.solve(false);

		// after you have called solve this will have the complete maze
		solver.printFinalMaze();
		

	}

}
