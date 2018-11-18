package strings;

import java.util.HashSet;
import java.util.Set;

public class SubSequences {

	/**
	 * 
	 * Algorithm
	 * 
	 * First iterate string
	 * 
	 * then iterate from end of string
	 * 
	 * in order to generate diff substring add it to list
	 * 
	 * one substring is added now iterate from k to length of this string
	 * and remove kth character and recur
	 * 
	 *   abc
	 *   	substring abc add
	 *   		remove char at 1 
	 *   		recur with ac
	 *   	substring ab  add
	 *   		remove char at 1
	 *   		recur with a  already added
	 *   	substring 
	 *   
	 *   	
	 *   
	 *   ac
	 *   	substring ac add
	 *   		remove char at 1
	 *   		recur with a
	 *   	substring a 
	 *   		already added do nothng	
	 *   
	 *   a
	 *   	substring a
	 *   	add a
	 *   
	 *   
	 *   bc
	 *   		substring bc
	 *   			same as above
	 *   
	 *   final result a,b,c,ab,ac,abc,bc
	 */
	
	Set<String> set = new HashSet<String>();
	public Set<String> subsequences(String str)
	{	
		for(int i =0;i<str.length();i++)
		{
			for(int j = str.length();j>i;j--)
			{
				
				String substr = str.substring(i, j);
				
				if(!set.contains(substr))
				{
					set.add(substr);
				}
				for(int k=1;k<substr.length()-1;k++)
				{
					StringBuilder sb = new StringBuilder(substr);
					sb.deleteCharAt(k);
	                   if (!set.contains(sb))
	                        
						subsequences(sb.toString());
				}
			}
		}
		
		return set;
	}
	
	   public static void main(String[] args)
	    {
	        String s = "aabc";
	        System.out.println(new SubSequences().subsequences(s));
	
	    }
}
