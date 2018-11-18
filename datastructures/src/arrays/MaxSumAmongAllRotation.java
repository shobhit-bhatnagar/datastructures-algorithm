package arrays;

public class MaxSumAmongAllRotation {

	 static int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static int maxSum()
	{
		int n = arr.length;
		
		int maxSum = 0;
		
		int arrSum = 0;
		for(int i =0;i<n;i++)
		{
			arrSum+=arr[i];
		}
		int currSum = 0;
		for(int i =0;i<n;i++)
		{
			currSum+= arr[i]*i;
		}
		
		maxSum = currSum;
		for(int i =1;i<n;i++)
		{
			currSum+=arrSum - n*(arr[n-i]);
			
			if(currSum > maxSum)
			{
				maxSum = currSum;
			}
		}
		return maxSum;
	}
	
	public static int maxSum(int []arr,int n)
	{
		
		
		int maxSum = 0;
		
		int arrSum = 0;
		for(int i =0;i<n;i++)
		{
			arrSum+=arr[i];
		}
		int currSum = 0;
		for(int i =0;i<n;i++)
		{
			currSum+= arr[i]*i;
		}
		
		maxSum = currSum;
		for(int i =1;i<n;i++)
		{
			currSum+=arrSum - n*(arr[n-i]);
			
			if(currSum > maxSum)
			{
				maxSum = currSum;
			}
		}
		return maxSum;
	}
	public static void main(String[] args) 
    {
        System.out.println("Max sum is " + maxSum());
        
        int arr[] = {8, 3, 1, 2};
        int n = arr.length;
        System.out.println(maxSum(arr, n));
    }
}
