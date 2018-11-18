package strings;

public class KMPStringMatching {
	
	public void KMPSearch(String pattern,String text)
	{
		int m = pattern.length();
		int n = text.length();
		
		int [] lps = new int[m];
		
		preProcessPatternForLCS(lps,pattern,m);
		
		int i =0;
		int j = 0;
		while(i<n)
		{
			if(pattern.charAt(j) == text.charAt(i))
			{
				i++;
				j++;
			}
			if(j == m)
			{
				System.out.println("pattern found at index "+(i-j));
			}
			else if(i <n && pattern.charAt(j) != text.charAt(i))
			{
				if(j!=0)
				{
					j = lps[j-1];
				}
				else
				{
					i++;
				}
			}
		}
	}

	/*
	 *  if characters match increment both i and j
	 *  if not
	 *  
	 *  then check if j is 0 then increment i as there is no characters left to compare with chat at i
	 *  
	 *  if not then set j to the value of  previous index in lps.
	 */
	public void preProcessPatternForLCS(int[] lps, String pattern, int m) {
		
		int j = 0;
		int i = 1;
		lps[0] = 0;
		
		while(i<m)
		{
			if(pattern.charAt(j) == pattern.charAt(i))
			{
				j++;
				lps[i] =j;
				i++;
			}
			else
			{
				if(j!=0)
				{
					j = lps[j-1];
				}
				
				else
				{
					lps[i] = j;
					i++;
				}
			}
		}
	}

	// Driver program to test above function
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        
        KMPStringMatching kmp = new KMPStringMatching();
        kmp.KMPSearch(pat, txt);
    }
	
}
