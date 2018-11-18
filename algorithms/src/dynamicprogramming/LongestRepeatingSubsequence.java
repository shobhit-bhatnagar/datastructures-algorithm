package dynamicprogramming;

/**
 * 
 * @author shobhit
 *
 *         Given a string, print the longest repeating subseequence such that
 *         the two subsequence don�t have same string character at same
 *         position, i.e., any i�th character in the two subsequences shouldn�t
 *         have the same index in the original string.
 */
public class LongestRepeatingSubsequence {

	
	public void longestRepeatedSubS(String X,String Y)
	{
		int m = X.length();
		int n = Y.length();
		
		
		int[][]lrs = new int[m+1][n+1];
		
		for(int i =0;i<=m;i++)
		{
			for(int j =0;j<=n;j++)
			{
				if(i==0||j==0)
				{
					lrs[i][j] = 0;
				}
				
				else if(X.charAt(i-1) == Y.charAt(j-1) && i != j)
				{
					lrs[i][j] = 1 + lrs[i-1][j-1];
				}
				else
				{
					lrs[i][j] = Integer.max(lrs[i-1][j], lrs[i][j-1]);
				}
			}
		}
		
		
		int i = m;
		int j = n;
		
		char[] res = new char[lrs[m][n]];
		
		int index = res.length-1;
		
		while(i>0 && j >0)
		{
			if(lrs[i][j] == lrs[i-1][j-1] +1)
			{
				res[index] = X.charAt(i-1);
				i--;j--;index--;
			}
			else if(lrs[i][j] == lrs[i-1][j])
			{
				i--;
			}
			else
			{
				j--;
			}
			
		}
		
		System.out.println(new String(res));
	}
	
	 public static void main (String[] args) 
	    {
	        String X = "AABEBCDD";
	        new LongestRepeatingSubsequence().longestRepeatedSubS(X, X);
	        
	       
	        
	    }
}
