package ds.labs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MazeSolver {

	private char[][] printMaze;
	private char[][] solveMaze;
	private StackArray<MazePosition> path = new StackArray<>();
	private boolean solved = false;

	public MazeSolver() {
		super();

	}

	/**
	 * Solves the maze by updating the solveMaze array. Starts at S finishes a F
	 * 
	 * @param printUpdates if true it will print every update to the map to standard
	 *                     i/o. If it is false it will only print the final
	 *                     completed map.
	 * @return true if this map was solved. False if it cannot be solved.
	 */
	private boolean solveMaze(boolean printUpdates) {
		
		MazePosition startingPoint;
		
		for(int i = 0; i < solveMaze.length; i++) {
			for(int j = 0; j < solveMaze[0].length; j++) {
				if(solveMaze[i][j] == 'S') {
					startingPoint = new MazePosition(i, j);
					path.push(startingPoint);
					break;
				}
			}
		}
		
		while(path.size() != 0) {
			MazePosition currPoint = path.peek();
			
			if(solveMaze[currPoint.row][currPoint.col] == 'F') {
				solved = true;
				return solved;
			}
			
			boolean moved = false;
			
			for(int i = 0; i < Direction.values().length; i++) {
				MazePosition nextPoint = Direction.values()[i].MoveToNewLocation(currPoint);
				
				if(nextPoint.isvalid() && solveMaze[nextPoint.row][nextPoint.col] != ' ') {
					solveMaze[nextPoint.row][nextPoint.col] = 'X';
					path.push(nextPoint);
					moved = true;
				}
			}
			
			if(printUpdates) {
				printFinalMaze();
			}
			
			if(moved == false) {
				path.pop();
			}
			
		}
		
		
		return solved;

	}

	/**
	 * Solves the maze by updating the solveMaze array. Starts at S finishes a F
	 * 
	 * @param printUpdates if true it will print every update to the map to standard
	 *                     i/o. If it is false it will only print the final
	 *                     completed map.
	 * @return true if this map was solved. False if it cannot be solved.
	 */
	public boolean solve(boolean printUpdates) {

		return solveMaze(printUpdates);
	}

	/**
	 * Solves the maze by updating the solvemaze array. Starts at S finishes a F
	 * 
	 * @return true if this map was solved.
	 */
	public boolean solve() {
		return solveMaze(false);
	}

	/**
	 * Prints the contents of maze array to to standard i/o. Should include the
	 * correct path through the maze.
	 */
	public void printFinalMaze() {
		for(int i = 0; i < solveMaze.length; i++) {
			for(int j = 0; j < solveMaze[0].length; j++) {
				System.out.print(" " + solveMaze[i][j] + " ");
			}
			
			System.out.println();
		}
	}

	/**
	 * Prints the contents of maze array to to standard i/o.
	 */
	private void printMaze(char[][] maze) {
		for(int i = 0; i < printMaze.length; i++) {
			for(int j = 0; j < printMaze[0].length; j++) {
				System.out.print(" " + printMaze[i][j] + " ");
			}
			
			System.out.println();
		}
	}

	/**
	 * Prints the contents of solve maze array to to standard i/o. This is mostly to
	 * test that you can print the maze
	 */
	public void printMaze() {
		printMaze(solveMaze);
	}

	/**
	 * Reads the file indicated by filename and loads it into both printMaze and
	 * solveMaze printMaze is a clean copy of the maze to use at the end to print
	 * the solution solveMaz is the working copy of the maze which will be altered
	 * to navigate a path.
	 * 
	 * @param filename the name of the file to be read map to standard i/o. If it is
	 *                 false it will only print the final completed map.
	 * @return true if the file was read successfully.
	 */
	public boolean loadMaze(String filename) {
		// if you want to load different mazes you may need to reset some things

		ArrayList<String> lines = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			// add a new character array of character arrays
			printMaze = new char[lines.size()][];
			solveMaze = new char[lines.size()][];
			int maxRows = lines.size();
			int maxCols = 0;
			for (int i = 0; i < lines.size(); i++) {
				// add a new character array to store the map characters
				printMaze[i] = new char[lines.get(i).length()];
				solveMaze[i] = new char[lines.get(i).length()];
				// maze is same width each row
				// so should be the same all the time...
				// but just in case
				maxCols = Math.max(maxCols, lines.get(i).length());
				for (int j = 0; j < lines.get(i).length(); j++) {
					// add the individual characters
					solveMaze[i][j] = lines.get(i).charAt(j);
					printMaze[i][j] = lines.get(i).charAt(j);

					// hint you may want to check for something here
					// what two things do you need to have...
					
				}
				// allows position to check if it is valid
				MazePosition.maxCol = maxCols;
				MazePosition.maxRow = maxRows;

			}

		} catch (IOException e) {

			e.printStackTrace();
			return false;

		}

		return true;
	}

}
