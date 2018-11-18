package hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromicPermutation {

	/*
	 *  check whether a string can be permuted to form a palindrome
	 */
	
	/*
	 * 
	 *  Logic
	 *   if number of character in string is even
	 *   then each character should  appear an even number of time
	 *   
	 *   if number of characters in string is odd
	 *   then each but one should appear even number of times and atmost one character shoud appear odd number of times
	 */
	
	public boolean isPalindromicPermutationPossible(String str)
	{
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i =0;i<str.length();i++)
		{
			char key = str.charAt(i);
			if(map.get(key) == null)
			{
				map.put(key, 0);
			}
			map.put(key, map.get(key)+1);
		}
		int length = str.length();
		boolean isEven = length%2==0;
		
		Iterator<Character> itr = map.keySet().iterator();
		int oddFreq = 0;
		while(itr.hasNext())
		{
			char key = itr.next();
			int val = map.get(key);
			
			if(val%2!=0)
			{
				oddFreq++;
			}
			
			if(isEven && oddFreq >0)
			{
				return false;
			}
			if(oddFreq>1)
			{
				return false;
			}
		}
		
		return true;
	}
}
