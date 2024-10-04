package ds.labs;
public enum Direction {
	Down('2',0,1),Right('6',1,0),RightDown('3',1,1),
	LeftDown('1',-1,1), Left('4',-1,0),	LeftUp('7',-1,-1),
	Up('8',0,-1), RightUp('9',1,-1);
	
	private static Direction[] directions = {null, LeftDown ,Down, RightDown,Left, null, Right, LeftUp, Up, RightUp  };
	
	public final char mapCharacter;
	public final  int deltaColumn;
	public final  int deltaRow;
	
	private Direction(char mapChar, int deltaColumn,int deltaRow )
	{
		this.mapCharacter = mapChar;
		this.deltaRow = deltaRow;
		this.deltaColumn = deltaColumn;
	}
	public static Direction getEnumfromChar(char map)
	{		
		int index = map - '0';
		if(index < 1 || index > 9 || index == 5)
		{
			throw new IllegalArgumentException();
		}		
		return directions[index];	
		
	}		
	
	public MazePosition MoveToNewLocation(MazePosition current)
	{
		
		
		return new MazePosition(current.row + deltaRow, current.col + deltaColumn);
		
	}
	
	
	
	
}