package arrays;

public class KthInSortedArrays {

	
	public int getKth(int []a1,int[]a2,int l1,int r1,int l2,int r2,int k)
	{
		if(l1==r1)
		{
			return a2[k];
		}
		if(l2==r2)
		{
			return a1[k];
		}
		
		int mid1= (r1-l1)/2;
		int mid2 = (r2-l2)/2;
		
		if(mid1+mid2 < k)
		{
			if(a1[mid1]>a2[mid2])
			{
				return getKth(a1, a2, l1, r1, l2+mid2+1, r2, k-mid2-1);
			}
			else
			{
				return getKth(a1, a2, l1+mid1+1, r1, l2, r2, k-mid1-1);
			}
		}
		else
		{
			if(a1[mid1]>a2[mid2])
			{
				return getKth(a1, a2, l1, l1+mid1, l2, r2, k);
			}
			else
			{
				return getKth(a1, a2, l1, r1, l2, l2+mid2, k);
			}
		}
	}
	
	public static void main(String[]args)
	{
		int[] a1= {2, 3, 6, 7, 9};
		int []a2 = {1, 4, 8, 10};
		
		System.out.println(new KthInSortedArrays().getKth(a1, a2, 0, 4, 0,3, 5));
		
	}
}
