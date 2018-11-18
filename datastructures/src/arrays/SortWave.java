package arrays;

import java.util.Arrays;

public class SortWave {

	
	 // A utility method to swap two numbers.
    void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
 
    // This function sorts arr[0..n-1] in wave form, i.e.,
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]....
    void sortInWave(int arr[], int n)
    {
    	
    	Arrays.sort(arr);
    	
    	for(int i =0;i<n;i=i+2)
    	{
    		if(i>0 && arr[i]<arr[i-1])
    		{
    			swap(arr,i-1,i);
    		}
    		if(i<n-1 && arr[i]<arr[i+1])
    		{
    			swap(arr,i,i+1);
    		}
    	}
    }
    
 // Driver program to test above function
    public static void main(String args[])
    {
        SortWave ob = new SortWave();
        int arr[] = {5,1,3,2,4};
        int n = arr.length;
        ob.sortInWave(arr, n);
        for (int i : arr)
            System.out.print(i+" ");
    }
}
