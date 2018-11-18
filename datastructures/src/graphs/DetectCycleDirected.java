package graphs;

import util.Graph;

public class DetectCycleDirected {

	
	public static boolean isCyclic(Graph g)
	{
		
		
		boolean []visited = new boolean[g.V];
		boolean []recursionStack = new boolean[g.V];
		
		for(int i=0;i<g.V;i++)
		{
			if(isCyclic(i, visited, recursionStack,g))
			{
				return true;
			}
		}
		return false;
	}

	private static  boolean isCyclic(int n, boolean[] visited, boolean[] recursionStack,Graph g) {
		
		visited[n] = true;
		
		// if a vertex is in recursion stack it means further calls will be through this vertex
		recursionStack[n] = true;
		
		for(int i =0;i<g.adjListArray[n].size();i++)
		{
			int k = g.adjListArray[n].get(i);
			if(!visited[k] && isCyclic(k,visited,recursionStack,g))
			{
				return true;
			}
			
			// this means k is already in recursion stack and this vertex k is already in recursion and this call is coming through that\
			// CYCLE
			else if(recursionStack[k])
			{
				return true;
			}
		}
		// remove it from recursion
		recursionStack[n] = false;
		return false;
	}
	
	public static void main(String args[])
    {
        Graph g = new Graph(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(isCyclic(g));
    }
}
