package arrays;

import java.util.HashMap;
import java.util.Map;

public class DistinctPairWithGivenSum {

	
	public int countPair(int [] arr,int sum)
	{
		int n = arr.length;
		
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		
		for(int i =0;i<n;i++)
		{
			if(!hm.containsKey(arr[i]))
			{
				hm.put(arr[i], 0);
			}
			hm.put(arr[i], hm.get(arr[i])+1);
		}
		int count=0;
		for(int i=0;i<n;i++)
		{
			int key = sum-arr[i];
			if(hm.get(key) !=null)
			{
				if(hm.get(key) > 1 && key !=arr[i])
				{
					count++;
				}
				else
				{
					count+=hm.get(key);
				}
			}
			
			if(key==arr[i])
			{
				count--;
			}
		}
		
		return count/2;
	}
	
	public static void main(String[] args)
	{
		
		
		int arr[] = new int[]{6,12,3,9,3,5,1,6} ;
		
		System.out.println(new DistinctPairWithGivenSum().countPair(arr, 12));
	}
}
