package arrays;
//max sum such that no two elements are adjacent

public class MaximumSum 
{

	 public static void main(String[] args)
	    {
	        MaximumSum sum = new MaximumSum();
	        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
	        System.out.println(sum.FindMaxSum(arr, arr.length));
	    }
// include 5 
	 // sum with 5 is 5 without 5 is 0   
	 // add next element sum including this is incl, exluding this = 5, excluding_new 5
	private int FindMaxSum(int[] arr, int length) {
		
		int incl = arr[0];
		int excl = 0;
		int excl_new = 0;
		
		for(int i = 1;i<arr.length;i++)
		{
			excl_new = (incl > excl) ? incl : excl;
			 
            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
			
		}
		
		return excl>incl?excl:incl;
	}
	 
}
