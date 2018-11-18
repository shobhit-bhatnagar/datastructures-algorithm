package dynamicprogramming;

public class KnapSackProblem
{

	/**
	 * 
	 * Algorithm
	 * 
	 * The maximum value that can be obtained from n items is max of following two values.
		1) Maximum value obtained by n-1 items and W weight (excluding nth item).
		2) Value of nth item plus maximum value obtained by n-1 items and W minus weight of the nth item (including nth item).
		
		K[V][W] = max(vi + K[V-1][W-wi] , K[V-1][W])  if wi<W
		else
		K[V][W] = K[V-1][W]
	 */
	
	 static int knapSack(int W, int wt[], int val[], int n)
	    {
	         int i, w;
	     int K[][] = new int[n+1][W+1];
	     
	     
	     for( i =0;i<=val.length;i++)
	     {
	    	 for(int j =0;j<=W;j++)
	    	 {
	    		 if(i==0||j==0)
	    		 {
	    			 K[i][j] = 0;
	    		 }
	    		 else if(wt[i-1]<=j)
	    		 {
	    			 K[i][j] = Integer.max(val[i-1]+K[i-1][j-wt[i-1]], K[i-1][j]);
	    		 }
	    		 else
	    		 {
	    			 K[i][j] = K[i-1][j];
	    		 }
	    	 }
	     }
	     
	     return K[n][W];
	    }
	 
	   // Driver program to test above function
	    public static void main(String args[])
	    {
	        int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack(W, wt, val, n));
	    }
}
