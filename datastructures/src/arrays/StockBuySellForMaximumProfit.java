package arrays;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellForMaximumProfit {

	
	static class Interval
	{
		int buy;
		int sell;
	}
	
	void stockBuySell(int[]price,int n)
	{
		
		if(n==1)
		{
			return;
		}
		List<Interval> list = new ArrayList<Interval>();
		int count =0;
		
		int i=0;
		while(i<n-1)
		{
			
			/*
			 * local minima is element such that element ahead of it is higher than it.
			 */
			while(i<n-1 && price[i+1]<=price[i])
			{
				i++;
			}
			if(i==n-1)
			{
				break;
			}
			Interval e = new Interval();
			e.buy=i++;
			
			while(i<n && price[i]>=price[i-1])
			{
				i++;
			}
			
			e.sell=i-1;
			
			count++;
			list.add(e);
		}
		
		   if (count == 0)
	            System.out.println("There is no day when buying the stock "
	                                                  + "will make profit");
	        else
	            for (int j = 0; j < count; j++)
	                System.out.println("Buy on day: " + list.get(j).buy
	                        +"        " + "Sell on day : " + list.get(j).sell);
	         
	        return;
	}
	
	 public static void main(String args[]) 
	    {  
		 
		 StockBuySellForMaximumProfit s = new StockBuySellForMaximumProfit();
	         
	        // stock prices on consecutive days
	        int price[] = {100, 180, 260, 310, 40, 535, 695};
	        int n = price.length;
	 
	        // fucntion call
	        s.stockBuySell(price, n);
	    }
}
