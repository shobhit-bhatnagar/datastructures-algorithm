package arrays;

import java.util.Arrays;

public class ApplyGivenPermutation {

	
	
	public void permute(int [] a, int[] perm)
	{
		/*
		 *  1,4,5
		 *  1,2,0
		 */
		
		for(int i =0;i<a.length;i++)
		{
			int next = i;
			
			while(perm[next] >=0 )
			{
				
				// swap a[0] with a[perm[0]]  1,4 swap next is 1 and perm[0] = 1-length
				swap(a,i,perm[next]);
				
				int temp = perm[next];
				perm[next]=perm[next]-a.length;
				next = temp;
			}
		}
	}
	private void swap(int[] a, int small, int equal) {
		
		int temp = a[small];
		a[small] = a[equal];
		a[equal] = temp;
	}
	
	// Driver method to test the above function
    public static void main(String[] args) 
    {
         
    	 int arr[] = new int[]{50, 40, 70, 60, 90};
    	 int index[] = new int[]{3,  0,  4,  1,  2};
        new ApplyGivenPermutation().permute(arr, index);;
         
        System.out.println("Reordered array is: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Modified Index array is:");
        System.out.println(Arrays.toString(index));
         
    }
}
