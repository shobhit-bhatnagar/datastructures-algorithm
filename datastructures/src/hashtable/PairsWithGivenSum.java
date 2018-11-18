package hashtable;

import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenSum {

	static int[] arr = {1, 5, 7, -1, 5};
	
	public static int getPairCount(int target)
	{
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(arr[i]) == null)
			{
				map.put(arr[i], 0);
			}
			map.put(arr[i], map.get(arr[i]) +1);
		}
		
		int count = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(target-arr[i]) != null)
			{
				count = count+map.get(target-arr[i]);
			}
			
			if(target-arr[i]==arr[i])
			{
				count--;
			}
	
		}
		
		return count/2;
	}
	// Driver method to test the above function
    public static void main(String[] args) {
         
        int sum = 6;
        System.out.println("Count of pairs is " + 
        		getPairCount(sum));
         
    }
}
