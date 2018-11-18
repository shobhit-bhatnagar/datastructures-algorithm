package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementPercisionArray {

	
public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        
        A.set(A.size()-1, A.get(A.size()-1)+1);
        
        for(int i=A.size()-1;i>0&& A.get(i)==10;i--)
        {
            A.set(i,0);
            A.set(i-1, A.get(i-1)+1);
        }
        
        if(A.get(0)==10)
        {
            A.add(1);
            A.set(0,0);
            for(int i =0;i<A.size()-1;i++)
            {
                int j = i+1;
                A.set(j,A.get(i));
            }
            A.set(0,1);
        }
        while(A.get(0) == 0)
        {
          A.remove(0);
        }
        
        return A;
    }
	

public ArrayList<Integer> maxset(ArrayList<Integer> A) {
    
    long maxSum = Long.MIN_VALUE;
    int maxStart = 0;
    int maxEnd = 0;
    long currSum = 0;
    int currStart = 0;
    
    for(int i=0;i<A.size();i++)
    {
        if(A.get(i) <0)
        {
            currStart = i+1;
            currSum=0;
            continue;
        }
        currSum += A.get(i);
        if(currSum >= maxSum)
        {
            
            if(currSum==maxSum)
            {
                if(maxEnd-maxStart+1 >= i-currStart+1)
                {
                    continue;
                }
            }
            maxStart = currStart;
            maxEnd = i;
            maxSum = currSum;
        }
    }
    if(maxSum<0 && currSum == 0 && currStart == A.size())
    {
        return new ArrayList<Integer>();
    }
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    for(int i = maxStart;i<=maxEnd;i++)
    {
        result.add(A.get(i));
    }
    
    return result;
}
	public static void main(String[]args)
	{
		int [] a = {0, 3, 7, 6, 4, 0, 5, 5, 5 };

		ArrayList<Integer> list = new ArrayList<Integer>() ;
		list.add(0);
		list.add(3);
		list.add(7);
		list.add(6);
		list.add(4);
		list.add(0);
		list.add(5);
		list.add(5);
		list.add(5);
		
		list = new ArrayList<Integer>() ;
		
		list.add(1967513926);
		list.add(1540383426);
		list.add(-1303455736);
		list.add(-521595368);
		
		
		new IncrementPercisionArray().maxset(list);
		
	}
}
