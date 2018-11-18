package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
	// represent weight using edge object each edge contains source vertex and
	// destination vertex and weight from u to v

	// this Graph is represented as list of edges and map of vertex
	// Edge is represented by vertex (u-v) and weight associated with it.
	// Each Vertex contains list of edges associated with it and also list of
	// adjacent.
	// we assign unique key to each vertex object at graph level.
	private List<Edge<T>> allEdges;

	private Map<Long, Vertex<T>> allVertex;

	public WeightedGraph() {
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long, Vertex<T>>();

	}

	/**
	 * @param id1
	 * @param id2
	 * @param weight
	 */
	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> u = null;
		if (allVertex.containsKey(id1)) {
			u = allVertex.get(id1);
		} else {
			u = new Vertex<T>(id1);
			allVertex.put(id1, u);
		}
		Vertex<T> v = null;
		if (allVertex.containsKey(id2)) {
			v = allVertex.get(id2);
		} else {
			v = new Vertex<T>(id2);
			allVertex.put(id2, v);
		}

		Edge<T> edge = new Edge<T>(u, v, weight);
		allEdges.add(edge);
		u.addAdjacentVertex(edge, v);
		v.addAdjacentVertex(edge,u);

	}

	public static class Vertex<T> {
		long id;
		private T data;
		private List<Edge<T>> edges = new ArrayList<>();
		private List<Vertex<T>> adjacentVertex = new ArrayList<>();

		Vertex(long id) {
			this.id = id;
		}

		public void addAdjacentVertex(Edge<T> edge, Vertex<T> v) {
			
			edges.add(edge);
			adjacentVertex.add(v);
			
		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the data
		 */
		public T getData() {
			return data;
		}

		/**
		 * @param data
		 *            the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}

		/**
		 * @return the edges
		 */
		public List<Edge<T>> getEdges() {
			return edges;
		}

		/**
		 * @param edges
		 *            the edges to set
		 */
		public void setEdges(List<Edge<T>> edges) {
			this.edges = edges;
		}

		/**
		 * @return the adjacentVertex
		 */
		public List<Vertex<T>> getAdjacentVertex() {
			return adjacentVertex;
		}

		/**
		 * @param adjacentVertex
		 *            the adjacentVertex to set
		 */
		public void setAdjacentVertex(List<Vertex<T>> adjacentVertex) {
			this.adjacentVertex = adjacentVertex;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;

			result = prime * result + (int) (id ^ (id >>> 32));
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (id != other.getId())
				return false;
			if (id != other.id)
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Vertex [id=" + id +"]";
		}

	}

 public	static class Edge<T> {

		private Vertex<T> u;
		private Vertex<T> v;
		private int weight;

		Edge(Vertex<T> u, Vertex<T> v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;

		}

		/**
		 * @return the u
		 */
		public Vertex<T> getU() {
			return u;
		}

		/**
		 * @param u
		 *            the u to set
		 */
		public void setU(Vertex<T> u) {
			this.u = u;
		}

		/**
		 * @return the v
		 */
		public Vertex<T> getV() {
			return v;
		}

		/**
		 * @param v
		 *            the v to set
		 */
		public void setV(Vertex<T> v) {
			this.v = v;
		}

		/**
		 * @return the weight
		 */
		public int getWeight() {
			return weight;
		}

		/**
		 * @param weight
		 *            the weight to set
		 */
		public void setWeight(int weight) {
			this.weight = weight;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((u == null) ? 0 : u.hashCode());
			result = prime * result + ((v == null) ? 0 : v.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (u == null) {
				if (other.u != null)
					return false;
			} else if (!u.equals(other.u))
				return false;
			if (v == null) {
				if (other.v != null)
					return false;
			} else if (!v.equals(other.v))
				return false;
			return true;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + ", weight=" + weight + "]";
		}
	}

	/**
	 * @return the allEdges
	 */
	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	/**
	 * @param allEdges the allEdges to set
	 */
	public void setAllEdges(List<Edge<T>> allEdges) {
		this.allEdges = allEdges;
	}

	/**
	 * @return the allVertex
	 */
	public Collection<Vertex<T>> getAllVertex() {
		return allVertex.values();
	}

	/**
	 * @param allVertex the allVertex to set
	 */
	public void setAllVertex(Map<Long, Vertex<T>> allVertex) {
		this.allVertex = allVertex;
	}
}
