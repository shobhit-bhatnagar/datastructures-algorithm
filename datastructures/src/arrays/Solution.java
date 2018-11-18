
package arrays;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Solution {
    public static void main(String args[] ) throws Exception {
    	
    	List<String> list = new ArrayList<>();
    	list.add("guava");
    	list.add("guava");
    	list.add("mango");
    	list.add("mango");
    	list.add("guava");
    	list.add("orange");
    	list.add("orange");
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    	
    	List<String> result = arrangeElemenets(list);
    	
    }

	private static List<String> arrangeElemenets(List<String> list) {
		
		PriorityQueue<WordWithCount> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		Map<String,Integer> map = new HashMap<>();
		
		for(String s:list)
		{
			if(map.get(s)==null)
			{
				map.put(s, 0);
			}
			
			map.put(s, map.get(s)+1);
		}
		
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext())
		{
			String word = itr.next();
			Integer count = map.get(word);
			queue.add(new WordWithCount(word,count));
		}
		
		List<String> result = new ArrayList<>();
		WordWithCount previous =null;
		WordWithCount current = null;
		if(queue.peek().count >= list.size()/2+1)
		{
			return null;
		}
		while(!queue.isEmpty())
		{
			 current = queue.poll();
			 if(previous != current)
			 {
				 result.add(current.word);
				 current.count = current.count-1;
			 }
			 if(previous !=null && previous.count>0)
			 {
				 queue.add(previous);
			 }
			 previous = current;
		}
		return result;
	}

	static class WordWithCount implements Comparable<WordWithCount>
	{

		Integer count = 0;
		String word = "";
		
		public WordWithCount(String word, Integer count)
		{
			this.word= word;
			this.count=count;
		}
		@Override
		public int compareTo(WordWithCount o) {
			
			return this.count.compareTo(o.count);
		}
		
	}
    
    
}
