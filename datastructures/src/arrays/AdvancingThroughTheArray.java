package arrays;

public class AdvancingThroughTheArray {

	public boolean isPossible(int [] a)
	{
		int furthest = 0;
		int lastIndex = a.length-1;
		
		for(int i =0;i<=furthest && furthest<lastIndex;i++)
		{
			furthest = Integer.max(furthest, a[i]+i);
		}
		
		return furthest>=a.length-1;
	}
	
	
	public void deleteKey(int[] a ,int key)
	{
		int writeIndex =0;
		
		/*
		 *  1,2,4,5,6
		 *  
		 *  delete 5 
		 *  
		 *  a[0] != 5 	 writeIndex 1
		 *  a[1] != 5  	writeIndex 2
		 *  a[2] != 5 	writeIndex 3
		 *  a[3] == 5 	writeIndex 3
		 *  a[4] != 5  overwrite a[3] by a[4] writeIndex 4
		 */
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=key)
			{
				a[writeIndex++]=a[i];
			}
		}
	}
	
	public void deleteDuplicateInSorted(int[]a)
	{
		
		int writeIndex = 1;
		
		for(int i = 1 ;i<a.length;i++)
		{
			if(a[writeIndex-1] != a[i])
			{
				a[writeIndex++]=a[i];
			}
		}
	}
	
}
