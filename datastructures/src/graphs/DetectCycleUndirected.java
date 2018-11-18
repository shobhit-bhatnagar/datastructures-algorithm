package graphs;

import java.util.LinkedList;
import java.util.List;

class DetectCycleUndirected {

	static class Graph
	{
		int V;
		List<Integer>[] adj;
		
		@SuppressWarnings("unchecked")
		public Graph(int v)
		{
			this.V=v;
			
			adj = new List[V];
			
			for(int i =0;i<V;i++)
			{
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int u ,int v)
		{
			adj[u].add(v);
			adj[v].add(u);
		}
	}
	
	 public static void main(String args[])
	    {
	        // Create a graph given in the above diagram
	        Graph g1 = new Graph(5);
	        g1.addEdge(1, 0);
	        g1.addEdge(0, 2);
	        g1.addEdge(2, 0);
	        g1.addEdge(0, 3);
	        g1.addEdge(3, 4);
	        if (isCyclic(g1))
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contains cycle");
	 
	        Graph g2 = new Graph(3);
	        g2.addEdge(0, 1);
	        g2.addEdge(1, 2);
	        if (isCyclic(g2))
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contains cycle");
	    }

	private static boolean isCyclic(Graph g1) {
		
		boolean []visited = new boolean[g1.V];
		
		for(int i = 0;i<g1.V;i++)
		{
			if(!visited[i])
			{
				if(isCyclicUtil(g1,visited,i,-1))
				{
					return true;
				}
			}
		}
		return false;
		
	}

	private static boolean isCyclicUtil(Graph g1, boolean[] visited, int v,int parent) 
	{

		visited[v] = true;
		
		for(int i =0;i<g1.adj[v].size();i++)
		{
			int n = g1.adj[v].get(i);
			
			if(!visited[n])
			{
				if(isCyclicUtil(g1, visited, n, v))
				{
					return true;
				}
			}
			else if(n!=parent)
			{
				return true;
			}
		}
		
		return false;
	}
}
