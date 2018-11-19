package graphs;

import java.util.HashMap;
import java.util.Map;

import util.WeightedGraph;
import util.WeightedGraph.Edge;
import util.WeightedGraph.Vertex;

public class BellManFordsAlgorithm {

	 public Map<Vertex<Integer>, Integer> getShortestPath(WeightedGraph<Integer> graph,
			 Vertex<Integer> sourceVertex) {
		 
		 Map<Vertex<Integer>, Integer> distance = new HashMap<>();
		 Map<Vertex<Integer>,Vertex<Integer>> parent = new HashMap<>();
		 
		 for(Vertex<Integer> vertex :graph.getAllVertex())
		 {
			 distance.put(vertex, Integer.MAX_VALUE);
			 parent.put(vertex, null);
		 }
		 
		 distance.put(sourceVertex, 0);
		 
		 int V = graph.getAllVertex().size();
		 
		 for(int i=0;i<V-1;i++)
		 {
			 for(Edge<Integer> edge : graph.getAllEdges())
			 {
				 Vertex<Integer> u =edge.getU();
				 Vertex<Integer> v = edge.getV();
				 // Relaxation algo
				 if(distance.get(u)+edge.getWeight() <distance.get(v))
				 {
					 distance.put(v, distance.get(u)+edge.getWeight());
					 parent.put(v, u);
				 }
			 }
		 }
		 
		 for (Edge<Integer> edge : graph.getAllEdges()) {
	            Vertex<Integer> u = edge.getU();
	            Vertex<Integer> v = edge.getV();
	            if (distance.get(u) + edge.getWeight() < distance.get(v)) {
	                throw new NegativeWeightCycleException();
	            }
	        }
	return distance;
	 }
	 
	 class NegativeWeightCycleException extends RuntimeException {
	 }
	 
	 public static void main(String[] arg){
	        
	        WeightedGraph<Integer> graph = new WeightedGraph<>();
	        graph.addEdge(0, 3, 8);
	        graph.addEdge(0, 1, 4);
	        graph.addEdge(0, 2, 5);
	        graph.addEdge(1, 2, -3);
	        graph.addEdge(2, 4, 4);
	        graph.addEdge(3, 4, 2);
	        graph.addEdge(4, 3, 1);

	        BellManFordsAlgorithm shortestPath = new BellManFordsAlgorithm();
	        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
	        Map<Vertex<Integer>,Integer> distance = shortestPath.getShortestPath(graph, startVertex);
	        System.out.println(distance);
	}
}
