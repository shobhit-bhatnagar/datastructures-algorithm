package graphs;

import java.util.Iterator;
import java.util.Stack;

import util.Graph;

public class TopologicalSort
{

	/**
	 * Its a linear ordering of vertex such that for every edge u,v u comes before e in topological sorting
	 * 
	 * Graph has to be dag 
	 * directed and acyclic
	 */
	
	
	public static void topologicalSorting(Graph g)
	{
	
		boolean[] visited = new boolean[g.V];
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i =0;i<g.V;i++)
		{
			if(!visited[i])
			topologicalSortingUtil(visited,i,s,g);
		}
		
		 while (s.empty()==false)
	            System.out.print(s.pop() + " ");
	}
	
	/**
	 * We can modify DFS to find Topological Sorting of a graph. In DFS, 
	 * we start from a vertex, we first print it and then recursively call 
	 * DFS for its adjacent vertices. In topological sorting, we use a 
	 * temporary stack. We don’t print the vertex immediately, 
	 * we first recursively call topological sorting for all its adjacent vertices,
	 *  then push it to a stack. Finally, print contents of stack. 
	 *  Note that a vertex is pushed to stack only when all of 
	 *  its adjacent vertices (and their adjacent vertices and so on) are already in stack.


	 * @param visited
	 * @param v
	 * @param s
	 * @param g
	 */

	private static void topologicalSortingUtil(boolean[] visited, int v, Stack<Integer> s,Graph g) {
		
		visited[v] = true;
		
		Iterator<Integer> itr = g.adjListArray[v].iterator();
		
		while(itr.hasNext())
		{
			int n = itr.next();
			if(!visited[n])
			{
					topologicalSortingUtil(visited,n,s,g);
			}
		}
		
		s.push(v);
	}
	
	 public static void main(String args[])
	    {
	        // Create a graph given in the above diagram
	        Graph g = new Graph(6);
	        g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	 
	        System.out.println("Following is a Topological " +
	                           "sort of the given graph");
	        topologicalSorting(g);
	    }
}
