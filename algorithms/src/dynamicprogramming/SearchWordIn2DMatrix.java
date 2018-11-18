package dynamicprogramming;

public class SearchWordIn2DMatrix {

	int []row = {-1,-1,-1,0,0,1,1,1};
	int []col = {-1,0,1,-1,1,-1,1,0};
	
	
	/**
	 * @param grid
	 * @param x
	 * @param y
	 * @param word
	 * @return
	 */
	public boolean searchWord(char[][] grid,int x,int y,String word)
	{
		if(grid[x][y] != word.charAt(0))
		{
			return false;
		}
		int k = 1;
		for(int i =0;i<8;i++)
		{
			int rd = x+row[i];
			int cd = y+col[i];
			
			for(k =1;k<word.length();k++)
			{
				if(rd<0 || rd>=grid.length || cd<0 || cd >=grid[0].length )
				{
					break;
				}
				if(grid[rd][cd] != word.charAt(k))
				{
					break;
				}
				rd+=row[i];
				cd+=col[i];
			}
			if(k==word.length())
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @param grid
	 * @param word
	 */
	public void patternSearch(char[][]grid,String word)
	{
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(searchWord(grid, i, j, word))
				{
					System.out.println("Row - "+i+", Col - "+j);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	    String []grid = new String[]{"GEEKSFORGEEKS",
	    							"GEEKSQUIZGEEK",
	    							"IDEQAPRACTICE"};
	 
	    char[][] grid1 = new char[3][14];
	    for(int i =0;i<grid1.length;i++)
	    {
	    	grid1[i] = grid[i].toCharArray();
	    }
	    
	   new SearchWordIn2DMatrix().patternSearch(grid1, "GEEKS");
	   
	}
}
