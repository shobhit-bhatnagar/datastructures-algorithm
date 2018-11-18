package arrays;

public class RearrangeMS {

	
	public static void rearrange(String [] arr)
	{
		int n = arr.length;
		// a1,a2,a3,a4,b1,b2,b3,b4
		int start = n/2;
		for(int i=1;i<n;i=i+2)
		{
			String temp = arr[start];
			for(int j=start;j>i;j--)
			{
				arr[j]=arr[j-1];
			}
			arr[i] = temp;
			start++;
		}
		
		for(String str:arr)
		{
			System.out.print(str+" ");
		}
	}
	
	public static void main(String[] args)
	{
		String[] a = {"a1","a2","a3","a4","a5","b1","b2","b3","b4","b5"};
		
		rearrange(a);
		
	}
}
