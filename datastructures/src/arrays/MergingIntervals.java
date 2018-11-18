  package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {
	
	static class Interval
	{
	
		int left;
		int right;
		public Interval(int min, int max) {
			this.left = min;
			this.right = max;
		}
		
		public String toString()
		{
			return "["+this.left+","+this.right+"]";
		}
	}
	
	
	/*
	 * 
	 *  Rules
	 *  
	 *  Two intervals I1 and I2 are merging if I2.start <= I1.right
	 *  and I2.end >= I1.end
	 */
	public List<Interval> mergeInterval(List<Interval> disjoint, Interval interval)
	{
		int i =0;
		
		List<Interval> result = new ArrayList<Interval>();
		// until overlapping is not found in sorted sequence
		while(i<disjoint.size() && interval.left > disjoint.get(i).right)
		{
			result.add(disjoint.get(i));
			i++;
		}

		while(i<disjoint.size() && interval.right>=disjoint.get(i).left)
		{
			interval = new Interval(Integer.min(interval.left, disjoint.get(i).left),
					Integer.max(interval.right, disjoint.get(i).right));
			i++;
		}
		result.add(interval);
		while(i<disjoint.size())
		{
			result.add(disjoint.get(i));
			i++;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		List<Interval> l = new ArrayList<Interval>();
		Interval i = new Interval(-4,-1);
		l.add(i);

		i = new Interval(0,2);
		l.add(i);
		i = new Interval(3,6);
		l.add(i);
		i = new Interval(7,9);
		l.add(i);
		i = new Interval(11,12);
		l.add(i);
		i = new Interval(14,17);
		l.add(i);
		int k = Integer.parseInt("00000");
		System.out.println(new MergingIntervals().mergeInterval(l, new Interval(1,8)).toString());
	}
}
