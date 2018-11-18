package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthLargestFrequency {

	
	public static void main(String[] args)
	{
		String str = "aaaabcbbdaaddcccdddddbbb";
		int res = kthLargest(str,6);
		if(res!=-1)
		{
			System.out.println((char)res);
		}
		else
		{
		System.out.println(res);
		}
	}

	private static int kthLargest(String str, int k) {
		
		int frequency[] = new int[256];
		Arrays.fill(frequency, 0);
		for(int i=0;i<str.length();i++)
		{
			int ind = str.charAt(i);
			frequency[ind]+=1;
		}
		
		List<Charc> list = new ArrayList<>();
		
		for(int i =0;i<str.length();i++)
		{
			int ind = str.charAt(i);
			
			
			
			Charc c = new Charc(ind,frequency[ind]);
			
			if(!list.contains(c))
				list.add(c);
		}
		
		Collections.sort(list);
		
		int j=1;
		if(k==1)
		{
			return list.get(0).index;
		}
		
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i).val == k)
			{
				return list.get(i).index;
			}
			
		}
		if(j==k)
		{
			return list.get(list.size()-2).index;
		}
		return -1;
	}
	
	static class Charc implements Comparable<Charc>
	{
		public int index;
		public Integer val;
		
		public Charc(int index,int val)
		{
			this.index = index;
			this.val = new Integer(val);
		}

		@Override
		public int compareTo(Charc o) {
			return o.val.compareTo(this.val);
		}
		
		public boolean equals(Object o)
		{
			if(o==null)
			{
				return false;
			}
			Charc c = (Charc)o;
			if(this.index == c.index)
			{
				return true;
			}
			return false;
		}
	}
}
