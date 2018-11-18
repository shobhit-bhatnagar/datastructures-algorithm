package arrays;

import java.util.Stack;

public class NextGreaterElement {

	
	static class IndexedElement
	{
		int data;
		int  index;
		public IndexedElement(int data,int index)
		{
			this.data = data;
			this.index = index;
		}
	}
	
	
	public int[] getNextGreaterElemList(int [] arr)
	{
		Stack<IndexedElement> s = new Stack<IndexedElement>();
		
		s.push(new IndexedElement(arr[0],0));
		int [] result = new int[arr.length];
		for(int j = 0;j<result.length;j++)
		{
			result[j]= -1;
		}
		for(int i =1;i<arr.length;i++)
		{
			int next = arr[i];
			
			if(!s.isEmpty())
			{
				IndexedElement element = s.pop();
				
				while(element.data < next)
				{
					result[element.index] = next;
					
					if(s.isEmpty())
					{
						break;
					}
					element  =s.pop();
				}
				if(element.data > next)
				{
					s.push(element);
				}
			}
			s.push(new IndexedElement(arr[i], i));
		}
		
		return result;
	}
	
	public static void main(String[] args) 
    {
        int arr[] = { 2,3,9,6,4,7,8,11,5};
       
        
        NextGreaterElement ng = new NextGreaterElement();
        int [] res = ng.getNextGreaterElemList(arr);
        
        for(int i = 0; i<res.length;i++)
        {
        	System.out.println(res[i]);
        }
    }
}
