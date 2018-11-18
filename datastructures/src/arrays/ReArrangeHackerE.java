package arrays;

/**
 * Find element in array
 * replace all occurences by 1 
 * and then move theses 1s to left
 * @author shobhit
 *
 */
public class ReArrangeHackerE {

	
	public static void main(String[] arg)
	{
		int []a = {1,2,22,4,5,22,34,16,22};
		
		// j 
		//1,1,1 1,2,4,5,34,16
		rearrange(a,22);
	}

	private static void rearrange(int[] a, int k) {
		
		int j=0;
		int count =0;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==k)
			{
				count++;
			}
			else
			{
				a[j]=a[i];
				j++;
			}
		}
		int n = a.length;
		int last = n-1;
		for(int i=n-count-1;i>=0;i--)
		{
			a[last]=a[i];
			last--;
		}
		
		for(int i=0;i<count;i++)
		{
			a[i]=1;
		}
		System.out.println();
		
	}
}
