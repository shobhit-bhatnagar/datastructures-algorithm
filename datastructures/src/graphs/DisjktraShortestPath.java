package graphs;

import java.util.HashMap;
import java.util.Map;

import graphs.BinaryHeap.Node;
import util.WeightedGraph;
import util.WeightedGraph.Edge;
import util.WeightedGraph.Vertex;

public class DisjktraShortestPath {

	
	 public Map<Vertex<Integer>,Integer> shortestPath(WeightedGraph<Integer> graph, Vertex<Integer> sourceVertex){
		 
		 Map<Vertex<Integer>, Integer> distance = new HashMap<Vertex<Integer>, Integer>();
		 
		 Map<Vertex<Integer>,Vertex<Integer>> parent = new HashMap<>();
		 
		 BinaryHeap<Vertex<Integer>> heap = new BinaryHeap<>();
		 
		 for(Vertex<Integer> vertex : graph.getAllVertex())
		 {
			 heap.add(Integer.MAX_VALUE, vertex);
		 }
		 heap.decrease(sourceVertex, 0);
		 parent.put(sourceVertex, null);
		 
		 while(!heap.isEmpty())
		 {
			Node<Vertex<Integer>> node = heap.extractMinNode();
			Vertex<Integer> current = node.key;
			 distance.put(current, node.weight);
			 
			 for(Edge<Integer> edge :current.getEdges())
			 {
				 Vertex<Integer> adjacent =  getAdjacentForEdge(current, edge);
				 if(!heap.contains(adjacent))
				 {
					 continue;
				 }
				 int newD = distance.get(current) + edge.getWeight();
				 if(heap.getWeight(adjacent) > newD)
				 {
					 heap.decrease(adjacent, newD);
					 parent.put(adjacent, current);
				 }
			 }
			 
		 }
		 
		return distance;
		 
	 }
	 private Vertex<Integer> getAdjacentForEdge(Vertex<Integer> current, Edge<Integer> edge) {
			
			return edge.getU().equals(current)?edge.getV():edge.getU();
		}
	 
	 public static void main(String args[]){
	        WeightedGraph<Integer> graph = new WeightedGraph<>();
	        /*graph.addEdge(0, 1, 4);
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

	        graph.addEdge(1, 2, 5);
	        graph.addEdge(2, 3, 2);
	        graph.addEdge(1, 4, 9);
	        graph.addEdge(1, 5, 3);
	        graph.addEdge(5, 6, 2);
	        graph.addEdge(6, 4, 2);
	        graph.addEdge(3, 4, 3);

	        DisjktraShortestPath dsp = new DisjktraShortestPath();
	        Vertex<Integer> sourceVertex = graph.getAllVertex().iterator().next();
	        Map<Vertex<Integer>,Integer> distance = dsp.shortestPath(graph, sourceVertex);
	        System.out.print(distance);
	}
}
