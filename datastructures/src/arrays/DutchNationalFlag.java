package arrays;

public class DutchNationalFlag {

	
	public void rearrangeElements(int[] a ,int k)
	{
		
		int pivot = a[k];
		
		int small=0;
		int equal=0;
		int large=a.length;
		
		while(equal<large)
		{
			if(a[equal] < pivot)
			{
				swap(a,small,equal);
				small++;
				equal++;
			}
			else if(a[equal] == pivot)
			{
				equal++;
			}
			else
			{
				swap(a,equal,--large);
		
			}
		}
		
	}

	private void swap(int[] a, int small, int equal) {
		
		int temp = a[small];
		a[small] = a[equal];
		a[equal] = temp;
	}
	
	public static void main(String[] args)
	{
		int[] a = {2,2,3,1,2,1};
		
		new DutchNationalFlag().rearrangeElements(a, 1);
	}
}
