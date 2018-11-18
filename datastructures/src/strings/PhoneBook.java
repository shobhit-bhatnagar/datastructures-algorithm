package strings;

import java.util.Iterator;

import strings.TrieDS.Trie;

public class PhoneBook {

	
	public void displayContacts(Trie trie, String str)
	{
		String prefix = "";
		int i;
		for( i = 0;i< str.length();i++)
		{
			prefix+= str.charAt(i);
			char last = str.charAt(i);
			
			Trie temp = trie.map.get(last);
			if(null == temp)
			{
				 System.out.println("No Results Found for prefix "+prefix + "");
                 i++;
                 break;
			}
			
			displayUtil(temp,prefix);
			
			trie = temp;
		}
		
		for(;i<str.length();i++)
		{
			System.out.println("No results found for "+prefix+str.charAt(i));
		}
	}
	
	private void displayUtil(Trie temp, String prefix) {
		
		if(temp != null)
		{
			 if(temp.isLeaf)
			 {
				 System.out.println(prefix);
			 }
			 
			 Iterator<Character> itr = temp.map.keySet().iterator();
			 while(itr.hasNext())
			 {
				 char key = itr.next();
				 
				 displayUtil(temp.map.get(key), prefix+key);
			 }
		}
		
	}

	public static void main(String [] args)
	{
		
		TrieDS trieDs = new TrieDS();
		TrieDS.root = new Trie();
		
		 
        String contacts [] = {"gforgeeks", "geeksquiz"};
 
        for(String str:contacts)
        {
        	trieDs.insert(str);
        }
        String query = "gekk";
 
        // Note that the user will enter 'g' then 'e' so
        // first display all the strings with prefix as 'g'
        // and then all the strings with prefix as 'ge'
        
        
        new PhoneBook().displayContacts(TrieDS.root,query);
	}
}
