package arrays;

import java.util.Arrays;

public class SearchInRotatedSorted {

	
	public int search(int[] arr, int key)
	{
		
		int pivot = findPivot(arr,0,arr.length-1);
		
		if(pivot == -1)
		{
			return Arrays.binarySearch(arr, key);
		}
		
		if(arr[pivot] == key)
		{
			return key;
		}
		if(arr[pivot] < key)
		{
		 return	binarySearch(arr,0,pivot-1,key);
		}
		return binarySearch(arr,pivot+1,arr.length-1,key);
	}

	private int binarySearch(int[] arr, int low, int high, int key) {
		if(low > high)
		{
			return -1;
		}
		 int mid = (low + high)/2;  
	       if (key == arr[mid])
	           return mid;
	       if (key > arr[mid])
	           return binarySearch(arr, (mid + 1), high, key);
	       return binarySearch(arr, low, (mid -1), key);
	}

	/**
	 * @param a
	 * @param l
	 * @param r
	 * @return
	 */
	public int findPivot(int[] a, int l, int r) {
		
		if(l>r)
		{
			return -1;
		}
		if(l==r)
		{
			return l;
		}

			int mid = (l+r)/2;
			
			if(mid<r && a[mid] > a[mid+1])
			{
				return mid;
			}
			if(mid>l && a[mid]<a[mid-1])
			{
				return mid-1;
			}
			
			if(a[l] >=a[mid])
			{
				return findPivot(a,l,mid-1);
			}
			return findPivot(a, mid+1, r);
	}
	 // main function
    public static void main(String args[])
    {
       // Let us search 3 in below array
       int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
       int n = arr1.length;
       int key = 3;
       System.out.println("Index of the element is : "
                      + new SearchInRotatedSorted().search(arr1, key));
    }
}
