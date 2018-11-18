package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirthmeticTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	
    	Map<Long,Long> right = new HashMap<>();
    	
    	Map<Long,Long> left = new HashMap<>();
    	for(Long l:arr)
    	{
    		right.put(l, right.getOrDefault(l, 0l)+1);
    	}
    	long res=0l;
    	for(Long l:arr)
    	{
    		right.put(l, right.get(l)-1);
    		if(l%r==0)
    		{
    			res+=left.getOrDefault(l/r,0l) * right.getOrDefault(l*r,0l);	
    		}
    		left.put(l,left.getOrDefault(l, 0l)+1);
    	}
    	return res;
    }

    private static long binomialCoeff(int n, int k) {
    	   
    	    
    	    long C[][] = new long[n+1][k+1];
    	    int i, j;
    	     
    	        // Calculate  value of Binomial Coefficient in bottom up manner
    	    for (i = 0; i <= n; i++)
    	    {
    	        for (j = 0; j <= Integer.min(i, k); j++)
    	        {
    	            // Base Cases
    	            if (j == 0 || j == i)
    	                C[i][j] = 1;
    	      
    	            // Calculate value using previosly stored values
    	            else
    	                C[i][j] = C[i-1][j-1] + C[i-1][j];
    	          }
    	     }
    	      
    	    return C[n][k];
	}

	public static void main(String[] args) throws IOException {
        
		List<Long> l = new ArrayList<>();
	
		
		
    	System.out.println(countTriplets(l, 5));
    }
}
