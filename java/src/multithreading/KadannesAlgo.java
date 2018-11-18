package multithreading;

public class KadannesAlgo {

	// 1, 2, 3,4,5,6
	public static int maxSum(int[] arr)
	{
		int sum = Integer.MIN_VALUE;
		
		int maxSoFar = arr[0];
		if(sum<maxSoFar)
		{
			sum = maxSoFar;
		}
		int currSum = sum;
		int si = 0;
		int ri = 0;
		
		for(int i=1;i<arr.length;i++)
		{
			currSum+=arr[i];
			if(currSum<maxSoFar)
			{
				currSum=arr[i];
				si++;
			}
			if(currSum>maxSoFar)
			{
				sum = currSum;
				maxSoFar = currSum;
				ri=i;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		int []a = {-1,-2,-3,-4,-5};
		System.out.println(maxSum(a));
	}
}
