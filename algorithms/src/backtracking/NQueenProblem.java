package backtracking;

public class NQueenProblem {

	static class Position
	{
		int row;
		int col;
		public Position(int row,int col)
		{
			this.row = row;
			this.col = col;
		}
	}
	
	
	public Position[] nQueenSoln(int n)
	{
		Position[] positions = new Position[n];
		boolean hasSolution = nQueenUtil(n,0,positions);
		if(hasSolution)
		{
			return positions;
		}
		
		return null;
	}


	private boolean nQueenUtil(int n, int row, Position[] positions) {
		
		if(row == n)
		{
			return true;
		}
		
		int col;
		for(col = 0;col<n;col++)
		{
			boolean foundSafe = true;
			for(int queen=0;queen<row;queen++)
			{
				if(positions[queen].col == col || positions[queen].row == row || positions[queen].row - positions[queen].col == row -col
						|| positions[queen].row + positions[queen].col == row+col)
				{
					foundSafe=false;
					break;
				}
			}
			if(foundSafe)
			{
				positions[row] = new Position(row,col);
				if(nQueenUtil(n, row+1, positions))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Position[] pos = new NQueenProblem().nQueenSoln(8);
		
		if(null == pos)
		{
			System.out.println("Not Found");
			return;
		}
		
		for(int i=0;i<pos.length;i++)
		{
			System.out.println("Q"+(i+1) +": "+pos[i].row + "," + pos[i].col);
		}
	}
}
