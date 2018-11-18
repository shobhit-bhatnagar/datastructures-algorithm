package dynamicprogramming;

public class LargestSumContiguousArray {

	
	public void largesetSumArray(int[] arr)
	{
		int maxSum = Integer.MIN_VALUE;
		int lb =0;
		int rb = 0;
		int start = 0;
		int currSum=0;
		for(int i =0;i<arr.length;i++)
		{
			 currSum+= arr[i];
			if(maxSum < currSum)
			{
				maxSum	= currSum;
				rb = i;
				start = lb;
			}
			 if(currSum < 0)
			{
				lb+=1;
				currSum = 0;
			}
			
			
		}
		System.out.println("Maximum contiguous sum is " + maxSum);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + rb);
	}
	
	   // Driver code
    public static void main(String[] args)
    {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        new LargestSumContiguousArray().largesetSumArray(a);
    }
}
