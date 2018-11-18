package arrays;

public class MultiplyTwoArray {

	
	public void multiply(int[] num1,int[] num2, int[] result)
	{
		reverse(num1);
		reverse(num2);
		
		for(int i = 0;i<num1.length;i++)
		{
			for(int j =0;j<num2.length;j++)
			{
				result[i+j]+=num1[i]*num2[j];
				
				result[i+j+1] += result[i+j]/10;
				result[i+j] = result[i+j]%10;
			}
		}
		
		int i = result.length-1;
		int originalLength = result.length;
		while(i>0 && result[i]==0)
		{
			originalLength--;
		}
		
		int [] res = new int[originalLength];
		
		for(int j =0;j<originalLength;j++)
		{
			res[j]= result[j];
		}
		
		reverse(res);
		
	}

	private void reverse(int[] num) {
		
		for(int i =0;i< num.length/2;i++)
		{
			int temp = num[i];
			num[i] = num[num.length-i-1];
			num[num.length-i-1] = temp;
		}
	}
	
	public static void main(String[] args)
	{
		int a[] = {1,2,3};
		int b[] = {9,8,7};
		new MultiplyTwoArray().multiply(a,b, new int[6]);
	}
}
