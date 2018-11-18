package arrays;

import java.util.Arrays;

public class NextPermutation {

	
	public int[] nextPermutation(int [] a)
	{
		
		
		/**
		 *  Algorithm
		 *  
		 *   start from end
		 *   and find a k such that elements from k+1 to length are in decreasing order
		 *   k such that a[k] < a[k+1] and  subarray k+1 to length is sorted in dec order
		 *   find  smalles a[l]  such that k+1<l<length-1 and a[l] > a[k] and smallest in subarray
		 *   swap a[l] and a[k] reverse subbarray
		 *   
		 *   
		 *   
		 */
		
		// step 1 find a k such that a[k] < a[k+1] 
		/// 1,2,3,4,5,6,7,10,9,8
		int k = a.length-2;
		while(k >= 0 && a[k]>=a[k+1])
		{
			k--;
		}
		
		if(k==-1)
		{
			return new int[]{};
		}
		
		// find and swap smallest entry greater than k in subarray
		
		for(int i =a.length-1;i>k;i--)
		{
			if(a[i] > a[k])
			{
				swap(a,i,k);
				break;
			}
		}
		int currLast = a.length -1;
		for(int i =k+1;i<currLast;i++)
		{
			swap(a,i, currLast);
			currLast--;
		}
		// reverse that subarray now
		return a;
	}
	
	private void swap(int[] a, int small, int equal) {
		
		int temp = a[small];
		a[small] = a[equal];
		a[equal] = temp;
	}
	public static void main(String[] args)
	{
		int [] a = new int[]{  735, 913, 378, 121, 632, 868, 504, 40, 455, 101, 896, 748, 448, 179, 371, 650, 462, 256, 474, 904, 550, 812, 587, 767, 967, 897, 79, 97, 67, 915, 307, 202, 470, 328, 699, 619, 707, 349, 891, 664, 561, 609, 303, 827, 949, 172, 217, 585, 608, 146, 91, 776, 344, 974, 252, 906, 240};
		
		System.out.println(Arrays.toString(new NextPermutation().nextPermutation(a)));
	}
}
