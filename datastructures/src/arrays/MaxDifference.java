package arrays;

public class MaxDifference {

	public void maxDiff(int []arr)
	{
		int minSoFar = arr[0];
		int diff = arr[1]-arr[0];
		
		for(int i = 1;i<arr.length;i++)
		{
			diff = Math.max(diff, arr[i]-minSoFar);
			if(arr[i]<minSoFar)
			{
				minSoFar = arr[i];
			}
		}
		
		System.out.println(diff);
	}
	
	public static void main(String[] args) 
    {
		MaxDifference maxdif = new MaxDifference();
        int arr[] = {1, 2, 90, 10, 110};
 
 
        maxdif.maxDiff(arr);
    }
}
