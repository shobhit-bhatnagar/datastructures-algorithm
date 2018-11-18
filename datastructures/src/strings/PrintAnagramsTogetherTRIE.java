package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class PrintAnagramsTogetherTRIE {

	static class Trie
	{
		Map<Character,Trie> map;
		boolean isLeaf;
		LinkedList<Integer> head;
		
		public Trie()
		{
			this.map = new HashMap<Character,Trie>();
			this.isLeaf = false;
			// initialize head only for a leaf node
		}
	}
	static Trie root;
	
	public void insert(String str,int index)
	{
		Trie tempNode = root;
		
		for(int i = 0;i<str.length();i++)
		{
			char key = str.charAt(i);
			
			if(tempNode.map.get(key) == null)
			{
				tempNode.map.put(key, new Trie());
			}
			tempNode = tempNode.map.get(key);
		}
		
		tempNode.isLeaf = true;
		if(null == tempNode.head )
		{
			tempNode.head = new LinkedList<Integer>();
		}
		tempNode.head.add(index);
	}
	
	
	public void printAnaGramsTogether(String[] str)
	{
		for(int i = 0;i<str.length;i++)
		{
			char[] charArray = str[i].toCharArray();
			
			Arrays.sort(charArray);
			
			insert(new String(charArray), i);
		}
		
		// traverse Trie 
		
		traverse(root,str);
	}
	
	 private void traverse(Trie root,String[]str) 
	 {
		 Trie tempNode = root;
			
			if(tempNode != null)
			{
				
				if(tempNode.isLeaf)
				{
					for(Integer index : tempNode.head)
					{
						System.out.println(str[index]);
					}
				}
				Iterator<Character> itr = tempNode.map.keySet().iterator();
			
				while(itr.hasNext())
				{
					char key = itr.next();
					
					traverse(tempNode.map.get(key),str);
				}
			}
		
	}


	public static void main(String args[])
	    {
	        String wordArr[] = {"cat", "dog", "tac", "god",
	                                        "act", "gdo"};
	        
	        root = new Trie();
	        new PrintAnagramsTogetherTRIE().printAnaGramsTogether(wordArr);
	    }
}
