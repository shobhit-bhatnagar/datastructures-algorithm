package strings;

import java.util.Arrays;

public class KthNonRepeatingCharacter {

	
	/*
	 * take two auxiliary array
	 * 
	 * count[256] count of each char, index[256] which will store 1 for all chars appeared only once n for rest
	 */
	
	public void kThNonRepeatingCharacter(String str, int k)
	{
		int[] count = new int[256];
		int[] index = new int[256];
		
		for(int i = 0;i<256;i++)
		{
			count[i] = 0;
			index[i] = str.length();
		}
		int n = str.length();
		
		for(int i = 0;i<str.length();i++)
		{
			char x = str.charAt(i);
			count[x] = count[x]+1;
			
			if(count[x] == 1)
			{
				index[x] = i;
			}
			if(count[x]== 2)
			{
				index[x] = n;
			}
		}
		Arrays.sort(index);
		
		char result ;
		if(index[k-1]!=str.length())
		{
			result = str.charAt(index[k-1]);
		}
		else
		{
			result = '#';
		}
		System.out.println(result);
	}
	
	  public static void main (String[] args) 
	    {
	        String str = "geeksforgeeks";
	        int k = 3;
	       new KthNonRepeatingCharacter().kThNonRepeatingCharacter(str, k);
	    }
}
