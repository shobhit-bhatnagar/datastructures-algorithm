package arrays;

public class RearrangeMaxMin {

	
	public static void rearrange(int[] arr,int n)
	{
		
		int max_val = arr[n-1]+1;
		int max_id = n-1;
		int min_id = 0;
		
		for(int i =0;i<n;i++)
		{
			if(i%2==0)
			{
				arr[i] = arr[i]+ (arr[max_id]%max_val)*max_val;
				max_id--;
			}
			else
			{
				arr[i] = arr[i]+(arr[min_id] %max_val)*max_val;
				min_id++;
			}
		}
		 // array elements back to it's original form
        for (int i = 0 ; i < n; i++)
            arr[i] = arr[i] / max_val ;
	}
	
	 public static void main(String args[])
	    {
	        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	        int n = arr.length;
	 
	        System.out.println("Original Array");
	        for (int i=0; i<n; i++)
	            System.out.print(arr[i] + " ");
	 
	        rearrange(arr, n);
	 
	        System.out.print("\nModified Array\n");
	        for (int i=0; i<n; i++)
	            System.out.print(arr[i] + " ");
	    }
}
