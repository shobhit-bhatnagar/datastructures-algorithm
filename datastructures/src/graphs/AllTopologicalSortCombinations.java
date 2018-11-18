package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllTopologicalSortCombinations {

	
	static class Graph
	{
		int V;
		LinkedList<Integer> []adj;
		List<Integer> inDegree;
		
		@SuppressWarnings("unchecked")
		public Graph(int V)
		{
			this.V = V;
			this.adj = new LinkedList[V];
			inDegree = new ArrayList<>();
			for(int i =0;i<V;i++)
			{
				this.adj[i] = new LinkedList<Integer>();
				inDegree.add(0);
			}
		}
		
		public void addEdge(int u,int w)
		{
			this.adj[u].add(w);
			inDegree.set(w, inDegree.get(w)+1);
		}
	}
	
	public static void topologicalSortAllCombs(Graph g)
	{
		boolean[] visited = new boolean[g.V];
		
		List<Integer> result = new ArrayList<Integer>();
		
		allTopologicalCombination(result,visited,g);
	}

	private static void allTopologicalCombination(List<Integer> result, boolean[] visited, Graph g) {
		
		boolean flag = false;
		for(int i =0;i<g.V;i++)
		{
			if(g.inDegree.get(i) == 0 && !visited[i])
			{
				// all other indegrees as zero and dfs with this vertex as starting
				
				for(Integer v:g.adj[i])
				{
					g.inDegree.set(v, g.inDegree.get(v)-1);
				}
				result.add(i);
				visited[i] = true;
				allTopologicalCombination(result, visited,g);
				
				visited[i] = false;
				
				result.remove(result.size()-1);
				for(Integer v:g.adj[i])
				{
					g.inDegree.set(v, g.inDegree.get(v)+1);
				}
				
				flag = true;
			}
		}
		if(!flag)
		{
			for(int i =0;i<result.size();i++)
			{
				System.out.print(result.get(i));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
	    // Create a graph given in the above diagram
	    Graph g = new Graph(6);
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);
	 
	    topologicalSortAllCombs(g);
	}
}
