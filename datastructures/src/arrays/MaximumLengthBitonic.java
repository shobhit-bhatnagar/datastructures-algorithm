package arrays;

public class MaximumLengthBitonic {

	
	public static int bitonic(int[] arr,int n)
	{
		int [] inc = new int[n];
		int []dec = new int[n];
		inc[0]=1;
		dec[n-1]= 1;
		for(int i =1;i<n;i++)
		{
			if(arr[i]>=arr[i-1])
			{
				inc[i] = inc[i-1]+1;
			}
			else
			{
				inc[i]=1;
			}
		}
		for(int i =n-2;i>=0;i--)
		{
			if(arr[i]>=arr[i+1])
			{
				dec[i]=dec[i+1]+1;
			}
			else
			{
				dec[i]=1;
			}
		}
	
		// Step 3) Find the length of maximum length bitonic sequence
		int max = inc[0] + dec[0] - 1;
		for (int i = 1; i < n; i++)
			if (inc[i] + dec[i] - 1 > max)
				max = inc[i] + dec[i] - 1;

		return max;
    }
	
	public static int maxLenBitonic(int[] a,int n)
	{
		if(n==0 || n==1)
		{
			return n;
		}
		
		int start=0;
		int nextStart=0;
		int j =0;
		int max=0;
		while(j<n-1)
		{
			while(j<n-1 && a[j] <=a[j+1])
			{
				j++;
			}
			while(j<n-1 && a[j] >=a[j+1])
			{
				if(j<n-1 && a[j]>a[j+1])
				{
					nextStart= j+1;
				}
				
				j++;
			}
			
			max = Integer.max(max, j-(start-1));
			
			start = nextStart;
		}
		return max;
    }
	
	 public static void main (String[] args)
	    {
	        int arr[] = {12, 4, 78, 90, 45, 23};
	        int n = arr.length;
	        System.out.println("Length of max length Bitnoic Subarray is "
	                            + bitonic(arr, n));
	        
	        System.out.println("Length of max length Bitnoic Subarray is "
                    + maxLenBitonic(arr, n));
	    }
}
