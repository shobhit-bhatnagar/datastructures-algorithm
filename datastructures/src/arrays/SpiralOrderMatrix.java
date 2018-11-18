package arrays;

import java.util.Arrays;

public class SpiralOrderMatrix {

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public int[] spiral(int[][] matrix)
	{
		// 0, 1 is for left to right keep row constant increment col
		// 1,0 keep col same increment row' up -> down
		// 0,-1 keep row same decrement col right to left
		
		//-1,0 keep col same decrement row down to up
		
		int [][] kShift = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int cols = matrix[0].length;
		int[] res = new int[cols*cols];
		int dir =0;
		int x= 0;
		int y = 0;
		
		for(int i =0;i<cols*cols; i++)
		{
			res[i] = matrix[x][y];
			matrix[x][y] = 0;
			int nextX = x+ kShift[dir][0];
			int nextY = y + kShift[dir][1];
			
			if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix.length
					|| matrix[nextX][nextY] == 0)
			{
				dir = (dir+1)% (4) ;//( dir value can be 0,1,2,3 for all directions)
				nextX = x+ kShift[dir][0];
				nextY = y+ kShift[dir][1];
			}
			x=nextX;
			y=nextY;
			
		}
		return res;
	}
	/// element such that element on right are greater and left are smaller
	static int findElement(int arr[], int n)
	{
		// leftMax[i] stores maximum of arr[0..i-1]
		int []leftMax = new int[n];
		leftMax[0] = Integer.MIN_VALUE;

		// Fill leftMax[]1..n-1]
		for (int i = 1; i < n; i++)
			leftMax[i] = Integer.max(leftMax[i-1], arr[i-1]);

		// Initialize minimum from right
		int rightMin = Integer.MAX_VALUE;

		// Traverse array from right
		for (int i=n-1; i>=0; i--)
		{
			// Check if we found a required element
			if (leftMax[i] < arr[i] && rightMin > arr[i])
				return i;

			// Update right minimum
			rightMin = Integer.min(rightMin, arr[i]);
		}

		// If there was no element matching criteria
		return -1;
	}
	
	public static void main(String[] args)
	{
		/*int [][]mat ={{1,2,3,10},{4,5,6,11},{7,8,9,12},{20,21,22,23}};
		
		SpiralOrderMatrix s = new SpiralOrderMatrix();
		
		
		System.out.println(Arrays.toString(s.spiral(mat)));*/
		
		int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
		findElement(arr, 9);;
		
	}
}
