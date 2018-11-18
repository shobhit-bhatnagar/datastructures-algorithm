package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author shobhit
 * write a program that takes set of events and determines maximum number of events
 * takes places concurrently
 */
public class RenderCalendar {

	
	static class Event
	{
		int start;
		int end;
		
		public Event(int start,int end)
		{
			this.start =start;
			this.end = end;
		}
	}
	
	static class Endpoint implements Comparable<Endpoint>
	{
		Integer time;
		boolean isStart;

		@Override
		public int compareTo(Endpoint o) {
			
			if(this.time != o.time)
			{
				return this.time.compareTo(o.time);
			}
			else
			{
				return this.isStart && !o.isStart ? -1:1;
			}
		}
		public String toString()
		{
			return "["+ this.time +"," + this.isStart+"]";
		}
		
	}
	
	public int findMaxConcurrent(List<Event> list)
	{
		int maxConcurrent =0;
		
		List<Endpoint> l = new ArrayList<Endpoint>();
		for(Event e:list)
		{
			Endpoint ep = new Endpoint();
			ep.time = e.start;
			ep.isStart = true;
			l.add(ep);
			ep = new Endpoint();
			ep.time = e.end;
			ep.isStart = false;
			l.add(ep);
		}
		
		Collections.sort(l);
		
		
		int simultaneous = 0;
		
		for(Endpoint e:l)
		{
			if(e.isStart)
			{
				simultaneous++;
				
				maxConcurrent = Integer.max(simultaneous, maxConcurrent);
			}
			else
			{
				simultaneous--;
			}
		}
		return maxConcurrent;
	}
	
	
	public static void main(String[] args)
	{
		List<Event> l = new ArrayList<Event>();
		
		Event e = new Event(1,5);
		l.add(e);
		e = new Event(2, 7);
		l.add(e);
		e = new Event(4,5);
		l.add(e);
		e = new Event(6, 7);
		l.add(e);
		e = new Event(8, 9);
		l.add(e);
		e = new Event(6, 10);
		l.add(e);
		e = new Event(9, 17);
		l.add(e);
		e = new Event(11, 13);
		l.add(e);
		e = new Event(12, 15);
		l.add(e);
		e = new Event(14, 15);
		l.add(e);
		
		System.out.println(new RenderCalendar().findMaxConcurrent(l));
	}
}
