package dynamicprogramming;

public class FindAllOccurenceOfAWord {

	int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	    char [][]grid = new char[][]{{'B', 'N', 'E', 'Y', 'S'},
                {'H', 'E', 'D', 'E', 'S'},
                {'S', 'G', 'N', 'D', 'E'}
              };
	 

	    
	   new FindAllOccurenceOfAWord().patternSearch(grid, "DEN");
	   
	}

	
	boolean isvalid(int row, int col, int prevRow, int prevCol)
	{
	    // return true if row number and column number
	    // is in range
	    return (row >= 0) && (row < 3) &&
	           (col >= 0) && (col < 5) &&
	           !(row== prevRow && col == prevCol);
	}
	private void patternSearch(char[][] grid, String string)
	{
		for(int i =0;i<3;i++)
		{
			for(int j = 0;j<5;j++)
			{
				if(grid[i][j] == string.charAt(0))
				{
					// row,col,prevRow,prevCol for visited check string and the index to start with
					DFS(grid,i,j,-1,-1,string,0,"");
				}
			}
		}
		
	}


	private void DFS(char[][] grid, int row, int col, int prevRow, int prevCol, String word, int index, String path) {

		if(index>=word.length() || grid[row][col] != word.charAt(index))
		{
			return;
		}
		
		path = path + word.charAt(index) + "["+row+","+col+"]";
		if(index == word.length()-1)
		{
			System.out.println(path);
		}
		
		for(int k =0;k<8;k++)
		{
			if(isvalid(row+rowNum[k], col + colNum[k], prevRow, prevCol))
			{
				DFS(grid,row+rowNum[k],col+colNum[k],row,col,word,index+1,path);
			}
		}
	}
}
