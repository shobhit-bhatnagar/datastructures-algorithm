package arrays;

public class PairWithGivenSumInSortedRotated {

	
	public boolean findPair(int [] arr, int sum)
	{
		
		int r = new SearchInRotatedSorted().findPivot(arr, 0, arr.length-1);
		
		int l = r+1;
		
		while(l!=r)
		{
			if(arr[l] + arr[r] == sum)
			{
				return true;
			}
			if(arr[l] + arr[r] < sum)
			{
				l = (l+1)%(arr.length);
			}
			else
			{
				r = (arr.length+r-1)%arr.length;
			}
		}
		return false;
	}
	
	 public static void main (String[] args)
	    {
	        int arr[] = {11, 15, 6, 8, 9, 10};
	        int sum = 16;
	        int n = arr.length;
	      
	        if (new PairWithGivenSumInSortedRotated().findPair(arr, sum))
	            System.out.print("Array has two elements" +
	                             " with sum 16");
	        else
	            System.out.print("Array doesn't have two" + 
	                             " elements with sum 16 ");
	    }
}
