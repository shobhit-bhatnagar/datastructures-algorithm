package dynamicprogramming;

public class MinimumCostPath {

	
	public static void minCostPath(int [][]cost)
	{
		int rows =cost.length;
		int cols = cost[0].length;
		
		int[][] dp = new int[rows][cols];
		dp[0][0]=cost[0][0];
		for(int i=1;i<rows;i++)
		{
			dp[i][0]=dp[i-1][0]+cost[i][0];
		}
		
		for(int j=1;j<cols;j++)
		{
			dp[0][j]=dp[0][j-1]+cost[0][j];
		}
		
		for(int i=1;i<rows;i++)
		{
			for(int j=1;j<cols;j++)
			{
				dp[i][j]=Integer.min(Integer.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +cost[i][j];
			}
		}
		
		System.out.println(dp[rows-1][cols-1]);
	}
	
	 public static void main(String args[])
	    {
	        int cost[][]= {{1, 2, 3},
	                       {4, 8, 2},
	                       {1, 5, 3}};
	       
	                                         minCostPath(cost);
	    }
}
