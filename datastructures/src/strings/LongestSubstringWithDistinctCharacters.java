package strings;

public class LongestSubstringWithDistinctCharacters {

	
	/**
	 * @param str
	 * @return
	 */
	
	/**
	 * 
	 * 
	 * a) The previous instance of character is not part of current NRCS (The
	 * NRCS which is under process). In this case, we need to simply increase
	 * cur_len by 1. (abbcda   bcda because previous instance of a is not part of current NRCS
	 * which is bcd)
	 * 
	 * b) If the previous instance is part of the current NRCS,
	 * then our current NRCS changes. It becomes the substring staring from the
	 * next character of previous instance to currently scanned character. We
	 * also need to compare cur_len and max_len, before changing current NRCS
	 * (or changing cur_len).
	 * 
	 * @param str
	 * @return
	 */
	public int findLongest(String str)
	{
		int currLen = 1;
		int maxLen = 1;
		
		int[] visited = new int[256];
		
		for(int i =0;i<255;i++)
		{
			visited[i]=-1;
		}
		
		visited[str.charAt(0)] = 0;
		
		int prevIndex;
		int i ;
		
		for(i=1;i<str.length();i++)
		{
			prevIndex = visited[str.charAt(i)];
			// if not visited and current substring with unique character does not contain repeated character
			// aabca
			// abbcda  current length 4  i-currLen 2  > 0
			if(prevIndex == -1 || i-currLen > prevIndex )
			{
				currLen++;
			}
			else  //if already visited and is also part of current Substring slide the substring by 1 from last index of it also update latest index
			{
				if(currLen > maxLen)
				{
					maxLen = currLen;
				}
				
				currLen = i-prevIndex;//( remove previous index from current index to calculate current index)
			}
			visited[str.charAt(i)] = i; //update new latest index
		}
		if(currLen > maxLen)
		{
			maxLen = currLen;
		}
		return maxLen;
	}
	
	public static void main(String[] args)
	{
		String str = "ABCDAAEF";
		System.out.println(new LongestSubstringWithDistinctCharacters().findLongest(str));
		/*
		 * for running stream u need to keep last index visited
		 * currLen
		 * MaxLength
		 * and the visited array
		 * 
		 * when updated string will come it will start from new char
		 */
	}
}
