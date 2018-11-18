package dynamicprogramming;

import java.util.Arrays;

public class MaxSumRectangleInMatix {

	
static  class CurrentState
 {
	 int maxSum = Integer.MIN_VALUE;
	 int start=0;
	 int end = 0;
 }
 
 
 public void maxSumSubarray(int [] arr,CurrentState cs)
 {
	 
	 int lb =0;
	 int rb=0;
	 int currentSum = 0;
	 int maxSum=Integer.MIN_VALUE;
	 int start=0;
	 for(int i =0;i<arr.length;i++)
	 {
		 currentSum+=arr[i];
		 if(currentSum>maxSum)
		 {
			 maxSum = currentSum;
			 lb = start;
			 rb=i;
		 }
		 if(currentSum<0)
		 {
			 start++;
			 currentSum=0;
		 }
		 
	 }
	 cs.maxSum=maxSum;
	 cs.start=lb;
	 cs.end=rb;
 }
 
 public void maxSumRectangle(int[][]mat)
 {
	 int rows = mat.length;
	 int cols=mat[0].length;
	 
	 
	 int[] dp = new int[rows];
	 
	 
	 int left=0,right=0,top=0,bottom=0;
	 
	 int maxSum=Integer.MIN_VALUE;
	 
	 
	 CurrentState cs = new CurrentState();
	 for(int i =0;i<cols;i++)
	 {
		 Arrays.fill(dp, 0);
		 
		 for(int j=i;j<cols;j++)
		 {
			 for(int k=0;k<rows;k++)
			 {
				 dp[k]+= mat[k][j];
				 
			 }
			 
			 maxSumSubarray(dp, cs);
			 if(maxSum<cs.maxSum)
			 {
				 left = i;
				 right = j;
				 maxSum=cs.maxSum;
				 top=cs.start;
				 bottom = cs.end;
			 }
		 }
	 }
	 
	 System.out.println("MaxSum: " + maxSum + 
             ", range: [(" + left + ", " + top + 
               ")(" + right + ", " + bottom + ")]");
 }
 
 public static void main (String[] args) throws java.lang.Exception
 {
     new MaxSumRectangleInMatix().maxSumRectangle(new int[][] {
                         {1, 2, -1, -4, -20},
                         {-8, -3, 4, 2, 1},
                         {3, 8, 10, 1, 3},
                         {-4, -1, 1, 7, -6}
                         });
 }
}
