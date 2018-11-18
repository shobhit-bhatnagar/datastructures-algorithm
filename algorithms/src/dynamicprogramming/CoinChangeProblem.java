package dynamicprogramming;

/**
 * 
 */
import java.util.Arrays;
import java.util.HashMap;

public class CoinChangeProblem {

	
	public static void makeChange(int[] arr,int sum)
	{
		
		int[]dp=new int[sum+1];
		Arrays.fill(dp, 0);
		dp[0]=1; //base
		
		//m is length of array containing coins
		for(int i=0;i<arr.length;i++)
		{
			for(int j=arr[i];j<=sum;j++)
			{
				dp[j]+=dp[j-arr[i]];
			}
		}
		System.out.println(dp[sum]);
	
		
		int[][] dp1 = new int[arr.length+1][sum+1];
		
	}
	
	public static int makeChange(int[] arr,int sum,int index,HashMap<String,Integer> map)
	{
		
		if(sum==0)
		{
			return 1;
		}
		if(index>=arr.length)
		{
			return 0;
		}
		String key = sum+"-"+index;
		
		if(map.get(key)!=null)
		{
			return map.get(key);
		}
		
		int ways=0;
		int amountWithCoins=0;
		
		while(amountWithCoins<=sum)
		{
			int remaining = sum-amountWithCoins;
			ways+=makeChange(arr, remaining,index+1,map);
			amountWithCoins+=arr[index];
		}
		
		map.put(key,ways);
		
		return ways;
	}
	 public static void main(String args[])
	    {
	        int arr[] = {1, 2, 3};
	        int m = arr.length;
	        int n = 4;
	     System.out.print(makeChange(arr, n,0,new HashMap<String,Integer>()));
	     makeChange(arr,n);
	    }
	
}
