package arrays;

import java.util.ListIterator;
import java.util.Stack;

public class StackSorter {

	
	static void sortStack(Stack<Integer> s)
	{
		if(!s.isEmpty())
		{
			int temp = s.pop();
			sortStack(s);
			
			insertInSorted(s,temp);
		}
	}
	
	static void insertInSorted(Stack<Integer> s,int temp)
	{
		if(s.isEmpty() || temp >s.peek())
		{
			s.push(temp);
			return;
		}
		
		int x = s.pop();
		insertInSorted(s, temp);
		s.push(x);
	}
	
	 static void printStack(Stack<Integer> s)
	    {
	       ListIterator<Integer> lt = s.listIterator();
	        
	       // forwarding
	       while(lt.hasNext())
	           lt.next();
	        
	       // printing from top to bottom
	       while(lt.hasPrevious())
	           System.out.print(lt.previous()+" ");
	    }
	   
	    // Driver method 
	    public static void main(String[] args) 
	    {
	        Stack<Integer> s = new Stack<>();
	        s.push(30);
	        s.push(-5);
	        s.push(18);
	        s.push(14);
	        s.push(-3);
	      
	        System.out.println("Stack elements before sorting: ");
	        printStack(s);
	      
	        sortStack(s);
	      
	        System.out.println(" \n\nStack elements after sorting:");
	        printStack(s);
	      
	    }
}
