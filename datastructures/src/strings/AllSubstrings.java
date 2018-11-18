package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class AllSubstrings {

	
	public void printSubstrings(String str)
	{
		
		
		for(int i = 0;i<str.length();i++)
		{
			for(int j =i+1;j<=str.length();j++)
			{
				System.out.println(str.substring(i, j));
			}
		}
	}
	
    public static void findSubstrings(String s) {  
    	
    	PriorityQueue<String> set = new PriorityQueue<String>(2);
    List<Character> l = new ArrayList<Character>();
    l.add('a');
    l.add('e');
    l.add('i');
    l.add('o');
    l.add('u');
    Character[] cons = new Character[]{'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
    List<Character> consonents = new ArrayList<Character>();
    consonents.addAll(Arrays.asList(cons));
    //aab
    for(int i=0;i<s.length();i++)
    {
        if(l.contains(s.charAt(i)))
        {
            for(int j=i+2;j<=s.length();j++)
            {
               if(consonents.contains(s.charAt(j-1)))
               {
                   set.add(new String(s.substring(i,j)));
               }
                
            }
        }
           
        
    }
    if(set.isEmpty())
    {
        return;
    }
    String result = set.poll();
    
    System.out.println(result);
    if(set.isEmpty())
    {
        System.out.println(result);
        return;
    }
    System.out.println(set.poll());}
	public static void main(String[] str)
	{
		
		AllSubstrings.findSubstrings("aab");
	}
}
