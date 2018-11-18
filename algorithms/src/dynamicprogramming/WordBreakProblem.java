package dynamicprogramming;

public class WordBreakProblem {
	
	
	public boolean dictionaryContains(String word)
	{
	    String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
	                           "icecream","and","go","i","like","ice","cream"};
	    int size = dictionary.length;
	    for (int i = 0; i < size; i++)
	        if (dictionary[i].equalsIgnoreCase(word))
	           return true;
	    return false;
	}
	
	public boolean wordBreak(String word)
	{
		boolean [] wb = new boolean[word.length()+1];
		
		for(int i=0;i<word.length();i++)
		{
			/**
			 * substring function here returns string from index i to index end -1
			 */
			if(wb[i] == false && dictionaryContains(word.substring(0, i)))
			{
				wb[i] = true;
			}
			if(wb[i])
			{
				if(i==word.length())
				{
					return true;
				}
				
				for(int j = i+1;j<=word.length();j++)
				{
					if(!wb[j] && dictionaryContains(word.substring(i,j)))
					{
						wb[j] = true;
					}
					if(j==word.length() && wb[j])
					{
						return true;
					}
				}
	
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		WordBreakProblem wb = new WordBreakProblem();
		
		System.out.println(wb.wordBreak("ilikesamsung"));
		System.out.println(wb.wordBreak("iiiiiiii"));
		System.out.println(wb.wordBreak("ilikelikeimangoiii"));
		System.out.println(wb.wordBreak("samsungandmango"));
		System.out.println(wb.wordBreak("samsungandmangok"));
	}
}
