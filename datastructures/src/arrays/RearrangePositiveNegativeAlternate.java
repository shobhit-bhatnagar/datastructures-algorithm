package arrays;

public class RearrangePositiveNegativeAlternate {

	
	public static void rearrange(int[] arr,int n)
	{
		int i =-1;
		int temp =0;
		
		for(int j =0;j<n;j++)
		{
			if(arr[j]<0)
			{
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int pos = i+1;
		int neg = 0;
		
		while(pos<n && neg < pos && arr[neg] < 0)
		{
			temp = arr[pos];
			arr[pos] = arr[neg];
			arr[neg] = temp;
			pos++;
			neg+=2;
		}
	}
	 static void printArray(int arr[], int n)
	    {
	        for (int i = 0; i < n; i++)
	            System.out.print(arr[i] + "   ");
	    }
	 
	    /*Driver function to check for above functions*/
	    public static void main (String[] args)
	    {
	        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
	        int n = arr.length;
	        rearrange(arr,n);
	        System.out.println("Array after rearranging: ");
	        printArray(arr,n);
	    }
}
