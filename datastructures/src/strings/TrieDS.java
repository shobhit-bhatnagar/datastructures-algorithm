package strings;

import java.util.HashMap;
import java.util.Map;

public class TrieDS {

	
	static class Trie
	{
		Map<Character,Trie> map = null;
		boolean isLeaf;
		
		public Trie()
		{
			this.isLeaf = false;
			map = new HashMap<Character,Trie>();
		}
	}
	
	static Trie root = null;
	public void insert(String str)
	{
		int n = str.length();
		Trie tempNode = root;
		for(int i = 0;i<n; i++)
		{
			if(tempNode.map.get(str.charAt(i)) == null )
			{
				tempNode.map.put(str.charAt(i), new Trie());
			}
			tempNode = tempNode.map.get(str.charAt(i));
		}
		
		tempNode.isLeaf = true;
	}
	
	public boolean searchPattern(String str)
	{
		
		Trie tempNode = root;
		
		for(int i = 0;i<str.length();i++)
		{
			char key = str.charAt(i);
			
			if(tempNode.map.get(key) != null)
			{
				tempNode = tempNode.map.get(key);
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean search(String str)
	{
		Trie tempNode = root;
		
		for(int i = 0;i<str.length();i++)
		{
			char key = str.charAt(i);
			
			if(tempNode.map.get(key) != null)
			{
				tempNode = tempNode.map.get(key);
			}
			else
			{
				return false;
			}
		}
		return tempNode != null && tempNode.isLeaf;
		
	}
	
	public void delete(String word)
	{
		delete(root,word,0);
	}
	
	 private boolean delete(Trie current, String word, int index) {
		
		 if(index == word.length())
		 {
			 if(!current.isLeaf)
			 {
				 return false;
			 }
			 
			 current.isLeaf = false;
			 return (current.map.size() == 0);
			 
		 }
		
		 char ch = word.charAt(index);
		 
		 if(current.map.get(ch) == null)
		 {
			 return false;
		 }
		 boolean shouldDelete = delete(current.map.get(ch),word,index+1);
		 
		 
		 if(shouldDelete)
		 {
			 current.map.remove(ch);
			 
			 return current.map.size() == 0;
		 }
		 
		 return false;
	}

	// Driver
    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
        root = new Trie();
      
        // Construct trie
        int i;
        TrieDS trie = new TrieDS();
        for (i = 0; i < keys.length ; i++)
        	trie.insert(keys[i]);
      
        // Search for different keys
        if(trie.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(trie.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(trie.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(trie.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
        
        if(trie.searchPattern("th") == true)
            System.out.println("th --- " + output[1]);
        else System.out.println("th --- " + output[0]);
        
    }
}
