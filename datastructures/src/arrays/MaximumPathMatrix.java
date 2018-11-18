package arrays;

// Find maximum sum of path from two ends
public class MaximumPathMatrix 
{
    public static int N = 4, M = 6;
     
    // Function to calculate max path in matrix
    static int findMaxPath(int mat[][])
    {
    	int maxSum = mat[0][0];
    	
    	for(int i=1;i<N;i++)
    	{
    		maxSum=-1;
    		for(int j=0;j<M;j++)
    		{
    			
    			// you can move to all three directions from j up upper right upper left
    			if(j>0 && j<M-1)
    			{
    				mat[i][j]+= Integer.max(Integer.max(mat[i-1][j-1],mat[i-1][j]),mat[i-1][j+1]);
    			}
    			else if(j>0)
    			{
    				mat[i][j]+=Integer.max(mat[i-1][j-1],mat[i-1][j]);
    			}
    			else if(j<M-1)
    			{
    				mat[i][j]+= Integer.max(mat[i-1][j], mat[i-1][j+1]);
    			}
    			maxSum = Integer.max(maxSum, mat[i][j]);
    		}
    	}
    	
    	return maxSum;
    }
     
    // driver program
    public static void main (String[] args) 
    {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                        { 1, 0, 0, 30, 2, 5 },
                        { 0, 10, 4, 0, 2, 0 },
                        { 1, 0, 2, 20, 0, 4 } 
                    };
 
        System.out.println(findMaxPath(mat));
    }
}
 