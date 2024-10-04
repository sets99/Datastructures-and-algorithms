package ds.labs;

import java.util.Objects;

public class MazePosition {

	public final int row;
	public final int col;
	
	public static int maxRow;
	public static int maxCol;
	
	@Override
	public int hashCode() {
		return Objects.hash(col, row);
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MazePosition other = (MazePosition) obj;
		return col == other.col && row == other.row;
	}

	public MazePosition(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	public boolean isvalid()
	{
		return (row < maxRow && col < maxCol && row >= 0 && col >= 0);
	}
	
}
