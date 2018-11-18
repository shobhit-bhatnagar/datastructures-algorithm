package graphs;

import java.util.LinkedList;
import java.util.Queue;

import util.Graph;

public class GraphTraversal {

	
	public static void main(String args[])
    {
        Graph g = new Graph(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        BFS(g,2);
        
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        DFS(g,2);
    }

	/**
	 * @param g
	 * @param s
	 */
	private static void BFS(Graph g, int s) {
	
		boolean [] visited = new boolean[g.V];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		visited[s] = true;
		
		while(!queue.isEmpty())
		{
			int v = queue.poll();
			System.out.println(v);
			for(int i =0;i<g.adjListArray[v].size();i++)
			{
				int n = g.adjListArray[v].get(i);
				if(!visited[n])
				{
					queue.add(n);
					visited[n] = true;
				}
				
			}
		}
		
	}
	
	/**
	 * @param g
	 * @param s
	 */
	private static void DFS(Graph g, int s)
	{
		boolean [] visited = new boolean[g.V];
		
		DFSUtil(g,visited,s);
	}

	/**
	 * @param g
	 * @param visited
	 * @param s
	 */
	private static void DFSUtil(Graph g, boolean[] visited, int s) {
		
		visited[s] = true;
		
		System.out.println(s);
		
		for(int i =0;i<g.adjListArray[s].size();i++)
		{
			int n = g.adjListArray[s].get(i);
			if(!visited[n])
			{
				DFSUtil(g, visited, n);
			}
		}
		
	}
}
