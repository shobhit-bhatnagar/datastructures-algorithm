package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Find number of ways to get sum s from n throws of dice with number 1 to m
 * @author shobhit
 *
 */
public class DiceThrow {

	Map<String,Integer> map = new HashMap<String,Integer>();
	public int numberOfWays(int m,int n, int sum)
	{
		// base cases
		
		if(sum > m*n || sum < n)
		{
			return 0;
		}
		if(sum == m*n || sum == n)
		{
			return 1;
		}
		
		int ways = 0;
		String key = n+"_"+sum;
		if(map.get(key) != null)
		{
			System.out.println(" found in cache ways to get sum "+sum+" with throws "+n+" is "+map.get(key));
			return map.get(key);
		}
		for(int i =1;i<=m;i++)
		{
			ways+=numberOfWays(m, n-1, sum-i);
		}
		map.put(key, ways);
		return ways;
	}
	
	
	public static void main(String[] args)
	{
		DiceThrow dt = new DiceThrow();
		
		System.out.println(dt.numberOfWays(4, 2,1));
		System.out.println(dt.numberOfWays(2, 2,3));
		System.out.println(dt.numberOfWays(6, 3,8));
		System.out.println(dt.numberOfWays(4, 2,5));
		System.out.println(dt.numberOfWays(4, 3,5));
	}
}
