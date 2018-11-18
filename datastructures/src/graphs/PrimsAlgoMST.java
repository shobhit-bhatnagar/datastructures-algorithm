package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import util.WeightedGraph;
import util.WeightedGraph.Edge;
import util.WeightedGraph.Vertex;

public class PrimsAlgoMST {

	// Find minimum spanning tree in weighted graph that is all vertices no cycle and minimum cost
	
	
	public static void main(String args[]){
        WeightedGraph<Integer> graph = new WeightedGraph<>();
     /* graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);*/

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimsAlgoMST prims = new PrimsAlgoMST();
        Collection<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
	}
/**
 * 
 * @param graph
 * @return
 * 										Algorithm
 * 										Initialize array of edges that makes mst as result.
 * 										Fetch all vertices of graph
 * 										Initialize a BinaryMinHeap with Maximum Int key to vertex 
 * 										Initialize vertexToEdge map that contains vertex to Edge mapping that is contained in result
 * 										Pick a Random Vertex and decrease this vertex weight to 0 
 * 										Iterate until heap is empty do following
 * 											1. Extract min value from heap in current Vertex
 * 											2. Add to result list (get the edge from vertexToEdge map if not null add edge to result
 * 											3. Explore all neighbors of current vertex (vertex.getEdges())
 * 											4. check if heap contains the adjacent vertex and weight associated in heap vertex is more than adjacent decrease the heap to current weight
 * 											5. Add adjacent to edge mapping to vertexToEdge
 * 										return result
 * 
 */
	private Collection<Edge<Integer>> primMST(WeightedGraph<Integer> graph) {
		
		Collection<Edge<Integer>> result = new ArrayList<>();
		BinaryHeap<Vertex<Integer>> heap = new BinaryHeap<>();
		Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();
		for(Vertex<Integer> vertex:graph.getAllVertex())
		{
			heap.add(Integer.MAX_VALUE, vertex);
		}
		//start from any random vertex
		Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
		heap.decrease(startVertex, 0);
		
		while(!heap.isEmpty())
		{
			Vertex<Integer> current = heap.extractMin();
			
			Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
			if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
			}
			for(Edge<Integer> edge:current.getEdges())
			{
				Vertex<Integer> adjacent = getAdjacentForEdge(current,edge);
				if(heap.contains(adjacent) && heap.getWeight(adjacent) > edge.getWeight())
				{
					heap.decrease(adjacent, edge.getWeight());
					vertexToEdge.put(adjacent, edge);
				}
			}
		}
		
		return result;
	}

	private Vertex<Integer> getAdjacentForEdge(Vertex<Integer> current, Edge<Integer> edge) {
		
		return edge.getU().equals(current)?edge.getV():edge.getU();
	}
	
	
}
