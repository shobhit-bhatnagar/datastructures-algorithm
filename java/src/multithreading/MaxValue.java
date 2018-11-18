package multithreading;

import java.util.ArrayList;
import java.util.List;

public class MaxValue {

	static class MaxThread extends Thread
	{
		
		private List<Integer> list;
		private int low;
		private int high;
		private int max = Integer.MIN_VALUE;
		public MaxThread(List<Integer> list,int low,int high)
		{
			this.list = list;
			this.low = low;
			this.high = high;
		}

		@Override
		public void run() {
			
			for(int i=low;i<high;i++)
			{
				max = Integer.max(list.get(i), max);
			}
			
		}

		public int getMax() {
			return max;
		}
		
	}
	
	
	public static void main(String[] arg) throws InterruptedException
	{
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0;i<20;i++)
		{
			list.add((int)(Math.random()*100));
		}
		System.out.println(list);
		List<MaxThread> threads = new ArrayList<>();
		for(int i =0;i<4;i++)
		{
			threads.add(new MaxThread(list, i*list.size()/4, (i+1)*list.size()/4));
			threads.get(i).start();
		}
		int max = Integer.MIN_VALUE;
		for(int i =0;i<4;i++)
		{
			threads.get(i).join();
			max = Integer.max(threads.get(i).getMax(), max);
		}
		
		System.out.println(max);
	}
}
