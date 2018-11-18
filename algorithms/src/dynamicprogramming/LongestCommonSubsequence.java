package dynamicprogramming;

public class LongestCommonSubsequence {

	
	/**
	 * Give a string find longest common subsequence and print it
	 */
	 
	 public int[][] lcs(String str1,String str2)
	 {
		 int m = str1.length();
		 int n = str2.length();
		 
		 int[][] result = new int[m+1][n+1];
		 
		 for(int i =0;i<=m;i++)
		 {
			 for(int j =0;j<=n;j++)
			 {
				 if(i==0 || j==0)
				 {
					 result[i][j] = 0;
				 }
				 else if(str1.charAt(i-1) == str2.charAt(j-1))
				 {
					 result[i][j] = 1+result[i-1][j-1];
				 }
				 else
				 {
					 result[i][j] = Integer.max(result[i-1][j], result[i][j-1]);
				 }
			 }
		 }
		 return result;
	 }
	 
	 public void printLCS(int[][] lcs,String str1,String str2)
	 {
		 
		 int m = str1.length();
		 int n = str2.length();
		 int lengthLongest = lcs[m][n];
		 char[] result = new char[lengthLongest];
		 
		 int i = m;
		 int j =n;
		 int index = lengthLongest -1;
		 
		 while(i>0 && j > 0)
		 {
			 if(str1.charAt(i-1)==str2.charAt(j-1))
			 {
				 result[index]= str1.charAt(i-1);
				 i--;
				 j--;
				 index--;
			 }
			 
			 else if(lcs[i-1][j] > lcs[i][j-1])
			 {
				 i--;
			 }
			 else
			 {
				 j--;
			 }
		 }
		 
		 for(int k=0;k<lengthLongest;k++)
		 {
			 System.out.print(result[k]);
		 }
	 }
	 
	 public static void main (String[] args) 
	    {
	        String X = "AGGTAB";
	        String Y = "GXTXAYB";
	        LongestCommonSubsequence l = new LongestCommonSubsequence();
	        
	        int[][]lc= l.lcs(X, Y);
	        
	        l.printLCS(lc, X, Y);
	        
	    }
}
