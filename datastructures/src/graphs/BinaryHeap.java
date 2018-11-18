package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * add, extract min, search in o(1) and decrease in o(log n)
 */
public class BinaryHeap<T> {

	List<Node<T>> queue = new ArrayList<>();
	static class Node<T>
	{
		public int weight;
		public T key;
		public Node(int weight, T key) {
			
			this.weight = weight;
			this.key = key;
		}
	}
	
	Map<T,Integer> map = new HashMap<T,Integer>();
	
	public void add(int weight,T key)
	{
		
		queue.add(new Node<>(weight,key));
		map.put(queue.get(queue.size()-1).key, queue.size()-1);
		
		 for (int i=queue.size()-1; i>=0; i--) 
	        { 
	            // Move current root to end 
			 	int parent = (i-1)/2;
			 	if(queue.get(parent).weight >queue.get(i).weight)
			 	{	
			 		swap(queue.get(parent), queue.get(i)); 
	  
	            // call max heapify on the reduced heap 
			 		heapify(i, 0);
			 	}
	        } 
		
	}
	
	/**
	 * @return
	 */
	public T extractMin()
	{
		T key = queue.get(0).key;
		queue.set(0, queue.get(queue.size()-1));
		map.remove(key);
		map.remove(queue.get(queue.size()-1).key);
		map.put(queue.get(0).key, 0);
		queue.remove(queue.size()-1);

		heapify(queue.size(), 0);
		return key;
	}
	
	/**
	 * @return
	 */
	public Node<T> extractMinNode()
	{
		Node<T> node = queue.get(0);
		T key = queue.get(0).key;
		queue.set(0, queue.get(queue.size()-1));
		map.remove(key);
		map.remove(queue.get(queue.size()-1).key);
		map.put(queue.get(0).key, 0);
		queue.remove(queue.size()-1);

		heapify(queue.size(), 0);
		return node;
	}
	/**
	 * @param n
	 * @param i
	 */
	void heapify(int n, int i) 
    { 
        int smallest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && queue.get(l).weight < queue.get(smallest).weight)
            smallest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && queue.get(r).weight <queue.get(smallest).weight) 
            smallest = r; 
  
        // If largest is not root 
        if (smallest != i) 
        { 
            Node<T> node = queue.get(i);   //  node , index i
            
            queue.set(i, queue.get(smallest)); //;,, index i contains node at index samallest  so map.put(node.get(smallest,i) map.put(node,smallest)
            queue.set(smallest,node); 
            updatePositionMap(node.key,queue.get(i).key,smallest,i);
  
            // Recursively heapify the affected sub-tree 
            heapify(n, smallest); 
        } 
    } 
	/**
	 * @param data1
	 * @param data2
	 * @param pos1
	 * @param pos2
	 */
	private void updatePositionMap(T data1, T data2, int pos1, int pos2){
        map.remove(data1);
        map.remove(data2);
        map.put(data1, pos1);
        map.put(data2, pos2);
	}
	
	public static void main(String args[]){
		BinaryHeap<String> heap = new BinaryHeap<String>();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2,"AFR");
        heap.decrease("Pramila", 1);
        while(!heap.queue.isEmpty())
        {
        	System.out.println(heap.extractMin());
        }
}
	
	public void printHeap(){
        for(Node n : queue){
            System.out.println(n.weight + " " + n.key);
        }
	}
	private void printPositionMap(){
        System.out.println(map);
		}
	
public boolean contains(T key)

{
	return map.get(key) != null;
}

public int getWeight(T key)
{
	return queue.get(map.get(key)).weight;
}
/**
 * Decreases the weight of given key to newWeight
 */
public void decrease(T data, int newWeight){
    Integer position = map.get(data);
    queue.get(position).weight = newWeight;
    
   
    int parent = (position -1 )/2;
    while(parent >= 0){
        if(queue.get(parent).weight > queue.get(position).weight){
            swap(queue.get(parent), queue.get(position));
            updatePositionMap(queue.get(parent).key,queue.get(position).key,parent,position);
            position = parent;
            parent = (parent-1)/2;
        }else{
            break;
        }
    }
	}

	private void swap(Node<T> node1,Node<T> node2){
		int weight = node1.weight;
		T data = node1.key;
    
		node1.key = node2.key;
		node1.weight = node2.weight;
    
		node2.key = data;
		node2.weight = weight;
}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
