package arrays;

public class SortedSubsequence {

	 static void find3Numbers(int arr[])
	    {
	        int n = arr.length;
	        int max = n-1; //Index of maximum element from right side
	        int min = 0; //Index of minimum element from left side
	        int i;
	 
	        // Create an array that will store index of a smaller
	        // element on left side. If there is no smaller element
	        // on left side, then smaller[i] will be -1.
	        int[] smaller = new int[n];
	        smaller[0] = -1;  // first entry will always be -1
	        
	        for( i =1;i<n;i++)
	        {
	        	if(arr[i]<arr[min])
	        	{
	        		min = i;
	        		smaller[i]=-1;
	        	}
	        	else
	        	{
	        		smaller[i]=min;
	        	}
	        }
	        
	        int[] larger = new int[n];
	        larger[n-1] = -1;  // first entry will always be -1
	        
	        for( i =n-2;i>=0;i--)
	        {
	        	if(arr[i]>=arr[max])
	        	{
	        		max = i;
	        		larger[i]=-1;
	        	}
	        	else
	        	{
	        		larger[i]=max;
	        	}
	        }
	        
	        for(i=1;i<n-1;i++)
	        {
	        	if(smaller[i]!=-1 && larger[i]!=-1)
	        	{
	        		System.out.print(arr[smaller[i]]+" "+
                            arr[i]+" "+ arr[larger[i]]);
	        		return;
	        	}
	        }
	        
	        
	    }
	 
	 public static void main (String[] args)
	    {
	        int arr[] = {12, 11, 10, 5, 6, 2, 30};
	        find3Numbers(arr);
	    }
}
