package util;

import java.util.LinkedList;

public class Graph {

	public int V;
   public	LinkedList<Integer> adjListArray[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v )
	{
		this.V=v;
		
		adjListArray = new LinkedList[v];
		
		for(int i=0;i<this.V;i++)
		{
			adjListArray[i]= new LinkedList<Integer>();
		}
	}
	
	/**
	 * @param graph
	 * @param src
	 * @param dest
	 */
	public void addEdge(int src, int dest)
    {
        // Add an edge from src to dest. 
        this.adjListArray[src].add(dest);
         
        // for undirected graph, add an edge from dest
        // to src also
        //graph.adjListArray[dest].addFirst(src);
    }
}
