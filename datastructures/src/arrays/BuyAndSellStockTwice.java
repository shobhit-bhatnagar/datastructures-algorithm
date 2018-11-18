package arrays;

public class BuyAndSellStockTwice {

	
	// Start with beggining and maintain array f[i..n] consist of max profit on ith day
	// traverse backward and find maxSoFar frm back and result max( maxSoFar-price[i]+f[i-1], maxProfit)
	
	
	public int buyAndSellTwice(int[] a)
	{
		
		int minSoFar = a[0];
		
		int maxProfit = Integer.MIN_VALUE;
		int [] f = new int[a.length];
		for(int i = 1;i<a.length;i++)
		{
			maxProfit = Integer.max(maxProfit, a[i]-minSoFar);
			if(a[i] < minSoFar)
			{
				minSoFar = a[i];
			}
			f[i] = maxProfit;
		}
		
		
		int maxSoFar = a[a.length-1];
		
		for(int i = a.length-1;i>0;i--)
		{
			maxSoFar = Integer.max(maxSoFar, a[i]);
			
			maxProfit = Integer.max(maxProfit, maxSoFar-a[i] + f[i-1]);
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args)
	{
		int [] a = {12,11,13,9,12,8,14,13,15};
		System.out.println(new BuyAndSellStockTwice().buyAndSellTwice(a));
	}
}
