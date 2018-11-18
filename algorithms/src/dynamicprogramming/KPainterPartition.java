package dynamicprogramming;
/**
 * ok Let me try to explain
assuming k = 2 and array a[] is {10,20,30,40}
Now so if k = 1 then we have a partition in place already for it which is 10,20,30,40
Assuming that we already have k-1 ( 1 in above case ) partitions in place (using k-2 dividers [ 0 in above case]), we now have to put the 1st divider to get k (2) partitions.

Idea here is to try adding partition in ith and i+1th positions so for above case
we can place our partition at following indices
1. After 10( between 0th index and 1st index) so our two partitions will be
{10} and {20,30,40} 
max of these two partitions is 90

2. After 20(between 1st index and 2nd index) so our two partitions will be
{10,20} and {30,40}
Max of these two is 70

3rd After 30(between 2nd index and 3rd index) so two partitions will be
{10,20,30} and {40}
max is 60

now minimum of above max values is 60 which is our answer.

DP table will be as follows for k = 2 and arr = {10,20,30,40}
1 2 3 4(Arrays indices)
=============================
(K)1 | 10 30 60 100 
2 |    10 20 30 60
 * @author shobhit
 *
 */
public class KPainterPartition {

	
	/**
	 * @param array
	 * @param k
	 * @return
	 */
	public static int partition(int[]array,int k)
	{
		int sum[] = new int[array.length+1];
		
		for(int i =1;i<=array.length;i++)
		{
			sum[i] = sum[i-1]+array[i-1];
		}
		
		int dp[][] = new int[k+1][array.length+1];
		
		
		/**
		 *      ==================================
		 *    1 |
		 *    2 |
		 *    3 |
		 *    4 |
		 *    5 |
		 *      |
		 *      |
		 *    k |
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		// base cases for k = 1
		int n = array.length;
		for(int i =1;i<=n;i++)
		{
			dp[1][i]+= sum[i];
		}
		// for n =1 
		for(int i =1;i<=k;i++)
		{
			dp[i][1] = array[0];
		}
		
		for(int i =2;i<=k;i++)
		{
			for(int j =2;j<=n;j++)
			{
				int best = Integer.MAX_VALUE;
				
				for(int p =1;p<=j;p++)
				{
					best = Integer.min(best, Integer.max(dp[i-1][p], sum[j]-sum[p]));
				}
				dp[i][j] = best;
			}
		}
		return dp[k][n];
	}
	
	public static void main(String args[])
	{
		int arr[] = { 10, 20, 60, 50, 30, 40 };

		int k = 3;

		System.out.println(partition(arr, k));
	}
}
