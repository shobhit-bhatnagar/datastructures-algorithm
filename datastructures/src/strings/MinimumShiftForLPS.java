package strings;

public class MinimumShiftForLPS {

	
	public void KMP(String str1, String str2)
	{
		int n = str1.length();
		int m  = str2.length();
		
		int [] lps = new int[n];
		KMPStringMatching km = new KMPStringMatching();
		km.preProcessPatternForLCS(lps, str1, n);
		int maxLength = 0;
		int shifts = 0;
		for(int i = 0,j=0;i<m;i++)
		{
			while(j>0 && str1.charAt(j) != str2.charAt(i))
			{
				j = lps[j];
			}
			if(str1.charAt(j) == str2.charAt(i))
			{
				j++;
			}
			
			if(j > maxLength)
			{
				maxLength = j;
				shifts = i-j+1;
			}
			
			if(j==n)
			{
				break;
			}
		}
		
		System.out.println("LPS " + str1.substring(0, maxLength));
		System.out.println("Shifts "+ shifts);
	}
	
	public static void main(String[] args)
	{
		String str1 = "geeksforgeeks";
		    String str2 = "forgeeksgeeks";
		    
		    str2 = str2 + str2;
		   new MinimumShiftForLPS().KMP(str1, str2);
		   
		
	}
}
