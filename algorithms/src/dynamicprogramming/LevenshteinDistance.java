package dynamicprogramming;

/**
 * 
 * Find minimum number of edits(add,delete,substitute) to convert one string to other
 * @author shobhit
 *
 *
 *E(A[0:a-1],B[0:b-1]) = 1+ min(E(A[0:a-2],B[0:b-2]), E(A[0:a-1],B[0:b-1]), E(A[0:a-2],B[0:b-1]))
 */
public class LevenshteinDistance {

	
	public static int editDistance(String s1,String s2)
	{
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i = 0;i<=s1.length();i++)
		{
			for(int j = 0;j<=s2.length();j++)
			{
				if(i==0)
				{
					// If first string is empty, only option is to
	                // isnert all characters of second string
					dp[i][j] = j;
				}
				else if(j==0)
				{
					dp[i][j] = i; //delete all from a if b is empty
				}
				
				else if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = 1+ Integer.min(dp[i][j-1], Integer.min(dp[i-1][j], dp[i-1][j-1]));
				}
			}
		}
		
		return dp[s1.length()][s2.length()];
	}
	
	 public static void main(String args[])
	    {
	        String str1 = "CARTHORSE";
	        String str2 = "ORCHESTRA";
	        System.out.println( editDistance( str1 , str2) );
	    }
}
