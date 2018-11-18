package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class TransformString {

	static Set<String> dictionary = new HashSet<>();
	
	public static void main(String[] args)
	{
		dictionary.add("damp");
		dictionary.add("lamp");
		dictionary.add("limp");
		dictionary.add("limp");
		dictionary.add("lime");
		dictionary.add("like");
		dictionary.add("camp");
		dictionary.add("came");
		dictionary.add("lame");
		
		
		int length =  transformedShortestLenght("damp", "limp");
		System.out.println(length);
	}

	/**
	 * @param s      damp --> camp -->came-->lame-->lime
	 * @param t       |
	 * 				 lamp-->limp
	 * @return
	 */
	private static int transformedShortestLenght(String s, String t) {
		
		Pair p = new Pair(s,0);
		LinkedList<Pair> queue = new LinkedList<>();
		
		queue.add(p);
		dictionary.remove(s);
		while(!queue.isEmpty())
		{
			p = queue.peek();
			if(p.s.equals(t))
			{
				return p.length;
			}
			String str = p.s;
			
			for(int i=0;i<s.length();i++)
			{
				
				for(int j=0;j<26;j++)
				{
					str = p.s.replace(p.s.charAt(i), (char) ('a'+j));
					
					if(dictionary.contains(str))
					{
						p = new Pair(str, p.length+1);
						dictionary.remove(str);
						queue.add(p);
					}
					//replace original
					
				}
				str = p.s;
				
			}
			queue.pop();
		}
		return -1;
	}
	
	static class Pair
	{
		
		
		public String s ;
		public int length;
		/**
		 * @return the s
		 */
		public String getS() {
			return s;
		}
		
		public Pair(String s,int i)
		{
			this.s=s;
			this.length=i;
		}
		/**
		 * @param s the s to set
		 */
		public void setS(String s) {
			this.s = s;
		}
		/**
		 * @return the length
		 */
		public int getLength() {
			return length;
		}
		/**
		 * @param length the length to set
		 */
		public void setLength(int length) {
			this.length = length;
		}
		
	}
}
