package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class SumSubset {

	// given a array find if a subset exist with given sum
	
	
	public static boolean isSubset(List<Integer> list, int sum)
	{
		if(list.isEmpty())
		{
			return false;
		}
		
		boolean[][]subset = new boolean[sum+1][list.size()+1];
		
		for(int i = 0;i<=list.size();i++)
		{
			subset[0][i]=true;
		}
		
		for(int i =1;i<=sum;i++)
		{
			subset[i][0]=false;
		}
		
		for(int i = 1;i<=sum;i++)
		{
			for(int j =1;j<=list.size();j++)
			{
				subset[i][j]= subset[i][j-1];
				if(i>=list.get(j-1))
				{
					subset[i][j] = subset[i][j] || subset[i-list.get(j-1)][j-1];
				}
			}
		}
		
		return subset[sum][list.size()];
	}
	
	 public static void main (String args[])
	    {
	        int set[] = {3, 34, 4, 12, 5, 2};
	        List<Integer> list = Arrays.asList(3, 34, 4, 12, 5, 2);
	        int sum = 9;
	        int n = set.length;
	        if (isSubset(list, sum) == true)
	            System.out.println("Found a subset"
	                          + " with given sum");
	        else
	            System.out.println("No subset with"
	                               + " given sum");
	    }
}
