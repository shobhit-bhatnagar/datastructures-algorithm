package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MedianInRowWiseSortedMatrix {
	/**
	 * 
	 * Give a row wise sorted matrix  C*N where C*N is odd
	 * find median
	 * 
	 */
	
	public static int medianInSorted(int[][] matrix )
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<m;i++)
		{
			min = Integer.min(matrix[i][0], min);
			max = Integer.max(matrix[i][n-1], max);
		}
		//
		int desired = (m*n +1)/2;
		int mid=0;
		while(min<max)
		{
			mid = min + (max-min)/2;
			int countLessThanGiven = 0;
			int get = 0;
			for(int i =0;i<m;i++)
			{
				
				// in every row try to find number of elements less than mid  if mid is found no of elems less than it are mid-1
				// else numb of elements less than it abs(mid) -1 
				get = Arrays.binarySearch(matrix[i], mid);
				
				if(get<0)
				{
					get = Math.abs(get) -1;
				}
				
				else
				{
					
					// for elements equal to mid also increment..
					while(get<matrix[i].length && matrix[i][get] == mid)
					{
						get++;
					}
				}
				countLessThanGiven+=get;
			}
			if(countLessThanGiven < desired)
			{  
				min=mid+1;
			}
			else
			{
				max=mid;
			}
		}
		return min;
	}
	
	
	  public static int findMedian(ArrayList<ArrayList<Integer>> A) {
	        
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
	        
	        int rows = A.size();
	        int columns = A.get(0).size();
	        int numberOfElements = 0;
	        for(int i =0;i<rows;i++)
	        {
	            min = Integer.min(A.get(i).get(0),min);
	            max = Integer.max(A.get(i).get(A.get(i).size()-1),max);
	            numberOfElements+= A.get(i).size();
	        }
	        
	        int desired = (numberOfElements+1)/2;
	        
	        int mid = 0;
	        
	        while(min<max)
	        {
	            mid = min+(max-min)/2;
	            int countLessThanCurrentMid = 0;
	            int get = 0;
	            for(int i =0;i<rows;i++)
	            {
	                get = Collections.binarySearch(A.get(i),mid);
	                
	                if(get<0)
	                {
	                    get= Math.abs(get) -1;
	                }
	                
	                else
	                {
	                    while(get<A.get(i).size() && A.get(i).get(get) == mid)
	                    {
	                        get++;
	                    }
	                }
	                countLessThanCurrentMid+=get;
	                
	            }
	            
	            if(countLessThanCurrentMid<desired)
	            {
	                min = mid+1;
	            }
	            else
	            {
	                max = mid;
	            }
	        }
	        
	        return min;
	    }
	public static void main(String[] args) 
    {
		
		//1,2,3,3,5,6,6,9,9
		
		//1   9   mid  1+4 = 5
        
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
         
        System.out.println("Median is " + medianInSorted(m));
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        for(int i =0;i<4;i++)
        {
        	list.add(new ArrayList<Integer>());
        }
        
        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(2);
        
        list.get(1).add(2);
        list.get(1).add(2);
        list.get(1).add(2);
        
        list.get(2).add(3);
        list.get(2).add(3);
        list.get(2).add(3);
        
        list.get(3).add(3);
        list.get(3).add(3);
        
        System.out.println("Median is " + findMedian(list));
        
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
				29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
				55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
				81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100, 101, 102, 103, 104, 105,
				106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126,
				127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147,
				148, 149, 150, 151, 152 };
        
		System.out.println(Arrays.binarySearch(a, 152));
        
    }
}
