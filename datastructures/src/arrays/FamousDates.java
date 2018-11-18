package arrays;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FamousDates {

	
    // Complete the solve function below.
	static class ReservationDates implements Comparable<ReservationDates>
	{
		private String date;
		private boolean isCheckout;

		public ReservationDates(String date, boolean isCheckout)
		{
			this.date=date;
			this.isCheckout = isCheckout;
		}

		@Override
		public int compareTo(ReservationDates o) {
			if(this.date.compareTo(o.date) == 0)
			{
				if(this.isCheckout)
				{
					return 1;
				}
				else if(o.isCheckout)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
			
			
			return this.date.compareTo(o.date);
		}
	}
    static String solve(List<List<String>> reservations) {
    	
    	List<ReservationDates> list = new ArrayList<>();
    	
    	reservations.stream().forEach(itr->{
    		list.add(new ReservationDates(itr.get(0), false));
    		list.add(new ReservationDates(itr.get(1), true));
    		itr.clear();
    	});

    	Collections.sort(list);
    	int max = 0;
    	int curr = 0;
    	String result = list.get(0).date;
    	for(int i=0;i<list.size();i++)
    	{
    		if(!list.get(i).isCheckout)
    		{
    			curr++;
    			if(curr>max)
    			{
    				max = curr;
    				result = list.get(i).date;
    			}
    		}
    		else
    		{
    			curr--;
    		}
    	}
    	return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<String>> reservations = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                    	
                        reservations.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = solve(reservations);

                System.out.println(result);
               // bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
