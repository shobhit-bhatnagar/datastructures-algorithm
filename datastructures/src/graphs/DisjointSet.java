package graphs;

import java.util.HashMap;

public class DisjointSet {

	HashMap<Integer,Node> map = new HashMap<>();
	static class Node
	{
		int data;
		int rank;
		Node parent;
	}
	
	
	public void makeSet(int x)
	{
		Node node = new Node();
		node.data = x;
		node.rank = 0;
		node.parent = node;
		map.put(x, node);
	}
	
	public void union(int x,int y)
	{
		
		Node n1 = map.get(x);
		Node n2 = map.get(y);
		Node xP = findSet(n1);
		Node yP = findSet(n2);
		
		if(xP.data == yP.data)
		{
			return;
		}
		
		if(xP.rank>=yP.rank)
		{
			xP.rank = xP.rank==yP.rank?xP.rank+1:xP.rank;
			yP.parent = xP;
		}
		else
		{
			xP.parent = yP;
		}
	}

	private Node findSet(Node n1) {
		
		Node parent = n1.parent;
		if(parent == n1)
		{
			return parent;
		}
		// compression step
		n1.parent = findSet(n1.parent);
		return n1.parent;
	}
	
	private int findSet(int n)
	{
		return findSet(map.get(n)).data;
	}
	
	 public static void main(String args[]) {
	        DisjointSet ds = new DisjointSet();
	        ds.makeSet(1);
	        ds.makeSet(2);
	        ds.makeSet(3);
	        ds.makeSet(4);
	        ds.makeSet(5);
	        ds.makeSet(6);
	        ds.makeSet(7);

	        ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        ds.union(3, 7);

	        System.out.println(ds.findSet(1));
	        System.out.println(ds.findSet(2));
	        System.out.println(ds.findSet(3));
	        System.out.println(ds.findSet(4));
	        System.out.println(ds.findSet(5));
	        System.out.println(ds.findSet(6));
	        System.out.println(ds.findSet(7));
	    }
}
