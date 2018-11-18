package binarysearchtrees;

public class ClosesEntriesInThreeSortedArrays {

	
	public int minInterval(int[] a, int[]b, int[]c)
	{
		
		int i=0;
		int j=0,k=0;
		int minDiff =Integer.MAX_VALUE;
		while(i<a.length && j<b.length && k<c.length)
		{
			int min = Integer.min(a[i], Integer.min(b[j], c[k]));
			
			int max  = Integer.max(a[i], Integer.max(b[j], c[k]));
			
			
			if(minDiff > max-min)
			{
				minDiff = max - min;
			}
			if(a[i] == min)
			{
				i++;
			}
			else if(b[j]==min)
			{
				j++;
			}
			else
			{
				k++;
			}
			
		}
		
		return minDiff;
	}
}
