package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shobhit There are N stations on route of a train. The train goes from
 *         station 0 to N-1. The ticket cost for all pair of stations (i, j) is
 *         given where j is greater than i. Find the minimum cost to reach the
 *         destination.
 */
public class MinCostFromSourceToDestination {

	
	//MinCost = Cost(0,N-1) = cost(0,1) + Min(1,N-1) , cost(0,2) + min(2, N-1) 
	
	
	
	public static int getMin(int [][]cost, int s,int d, Map<String,Integer>memo)
	{
		if(s==d || s+1==d)
		{
			return cost[s][d];
		}
		String key = s+"-"+d;
		
		if(memo.get(key)!=null)
		{
			System.out.println("Found in cache");
			memo.get(key);
		}
		int min = cost[s][d];
		
		for(int i = s+1;i<d;i++)
		{
			int c = getMin(cost, s, i,memo)  + getMin(cost, i, d,memo);
			if(c<min)
			{
				min = c;
			}
		}
		memo.put(key, min);
		return min;
	}
	
	public static int getMin(int [][]cost)
	{
		int [] dist = new int[cost[0].length];
		
		for (int i=0; i<dist.length; i++)
	           dist[i] = Integer.MAX_VALUE;
		dist[0] = 0;
		
		for(int i=0;i<dist.length;i++)
		{
			for(int j=i+1;j<dist.length;j++)
			{
				
				
				if(dist[j]> dist[i]+cost[i][j])
				{
					dist[j] = dist[i]+cost[i][j];
				}
			}
		}
		return dist[dist.length-1]; 
	}
	
	public static void main(String args[])
    {
        int cost[][] = { {0, 15, 80, 90, 50},
                      {Integer.MAX_VALUE, 0, 40, 50,60},
                      {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 70,80},
                      {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0,90},
                      {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0,0}
                    };
        System.out.println("The Minimum cost to reach station 4" +
                                              " is "+getMin(cost,0,4, new HashMap<>()));
    }
}
