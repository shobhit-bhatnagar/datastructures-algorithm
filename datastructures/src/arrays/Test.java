package arrays;

import java.util.Arrays;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Test
{
    static int arr[] = new int[]{3,0,0,0,0,0};
     
    // Method for maximum amount of water
    static int findWater(int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];
      
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];
      
        // Initialize result
        int water = 0;
      
        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
           left[i] = Math.max(left[i-1], arr[i]);
      
        // Fill right array
        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--)
           right[i] = Math.max(right[i+1], arr[i]);
      
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
           water += Math.min(left[i],right[i]) - arr[i];
      
        return water;
    }
     
    // Driver method to test the above function
    public static void main(String[] args) 
    {
         
      int i =99999;
      int [] a = {1,3,7,7,11,13,15,18};
      
      int j = Arrays.binarySearch(a, 0);
     
      System.out.println(j);
    }
    
    static int marsExploration(String s) {

        //compare letters in group of three with sos and keep the count
        int diff = 0;
        String original = "SOS";
        for(int i=0;i<s.length();i=i+3)
        {
            String received = s.substring(i,i+3);
            if(received.equals(original))
            {
            	continue;
            }
            for(int j=0;j<3;j++)
            {
                if(received.charAt(j) != original.charAt(j) )
                {
                    diff++;
                }
            }
        }
        new Test().notifyAll();
        return diff;
        //Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //.map(Long::parseLong)
        //.collect(toList());
    }
    
    static int flatlandSpaceStations(int n, int[] c) {

        int[] cities = new int[n];
        int max = Integer.MIN_VALUE;
        int j=0;
        Arrays.sort(c);
        cities[0]= c[0]-0;
        if(c[0]==0)
        {
        	j++;
        }
        max= Integer.max(max, cities[0]);
        
        for(int i=1;i<n;i++)
        {
            if(j <c.length && i==c[j])
            {
                cities[i]=0;
                j++;
                
            }
            else 
            {
            	if(j==c.length)
            	{
            		j=j-1;
            	}
                cities[i]= Integer.min(cities[i-1]+1, Math.abs(c[j]-i));
                max= Integer.max(max, cities[i]);
            }
        }
        
        return max;
    }
}
