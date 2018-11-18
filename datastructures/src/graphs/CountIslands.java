package graphs;

public class CountIslands {

	   //No of rows and columns
    static final int ROW = 5, COL = 5;
 
    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
    	if(row>=0 && row<CountIslands.ROW && col >=0 && col <CountIslands.COL && !visited[row][col]&& M[row][col]==1 )
    	{
    		return true;
    	}
    	return false;
    } 
	// Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };
         CountIslands I = new CountIslands();
        System.out.println("Number of islands is: "+ I.countIslands(M));
    }
	/**
	 * @param M
	 * @return
	 */
	private String countIslands(int[][] M) {
		
		int count = 0;
		boolean[][] visited = new boolean[CountIslands.ROW][CountIslands.COL];
		
		for(int i =0;i<M.length;i++)
		{
			for(int j = 0;j<M.length;j++)
			{
				if(M[i][j] == 1 && !visited[i][j])
				{
					DFS(M,i,j,visited);
					++count;
				}
			}
		}
		int c2=0;
		 visited = new boolean[CountIslands.ROW][CountIslands.COL];
		for(int i =0;i<M.length;i++)
		{
			for(int j = 0;j<M.length;j++)
			{
				if(M[i][j] == 1 && !visited[i][j])
				{
					DFSVersion2(M,i,j,visited);
					++c2;
				}
			}
		}
		System.out.println(c2);
		return String.valueOf(count);
	}
	/**
	 * @param M
	 * @param x
	 * @param y
	 * @param visited
	 */
	private void DFS(int[][] M, int x, int y, boolean[][] visited) {
		
		visited[x][y] = true;
		
		
		
		int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        
        for(int k =0;k<8;k++)
        {
        	if(isSafe(M, x+rowNbr[k], y+colNbr[k], visited))
        	{
        		DFS(M,x+rowNbr[k],y+colNbr[k],visited);
        	}
        }
		
	}
	private void DFSVersion2(int[][] M, int x, int y, boolean[][] visited) {
		
		visited[x][y] = true;
		
		int[][]dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
		
		
        for(int i=0;i<dir.length;i++)
        {
        	int nextX = x+dir[i][0];
        	int nextY = y+dir[i][1];
        	if(isSafe(M, nextX,nextY, visited))
        	{
        		DFS(M,nextX,nextY,visited);
        	}
        }
		
	}
}
