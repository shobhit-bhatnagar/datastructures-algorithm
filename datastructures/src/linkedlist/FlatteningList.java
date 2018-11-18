package linkedlist;

public class FlatteningList {

Node head;
	static class Node
	{
		int data;
		Node next;
		Node down;
		
		public Node(int data)
		{
			this.data = data;
			this.next = null;
			this.down = null;
		}
	}
	
	public Node flatten(Node root)
	{
		if(root == null || root.next == null)
		{
			return root;
		}
		
		root.next = flatten(root.next);
		
		root = merge(root,root.next);
		
		return root;
		
		
	}

	private Node merge(Node root, Node next) {


		if(root == null )
		{
			return next;
		}
		if(next == null)
		{
			return root;
		}
		Node result = null;
		if(root.data < next.data)
		{
			result = root;
			result.down = merge(root.down, next);
		}
		else
		{
			result = next;
			result.down = merge(root, next.down);
			
		}
		
		return result;
	}
	
	 Node push(Node head_ref, int data)
	    {
	        /* 1 & 2: Allocate the Node &
	                  Put in the data*/
	        Node new_node = new Node(data);
	 
	        /* 3. Make next of new Node as head */
	        new_node.down = head_ref;
	 
	        /* 4. Move the head to point to new Node */
	        head_ref = new_node;
	 
	        /*5. return to link it back */
	        return head_ref;
	    }
	 
	    void printList()
	    {
	        Node temp = head;
	        while (temp != null)
	        {
	            System.out.print(temp.data + " ");
	            temp = temp.down;
	        }
	        System.out.println();
	    }
	 
	    /* Drier program to test above functions */
	    public static void main(String args[])
	    {
	        FlatteningList L = new FlatteningList();
	 
	        /* Let us create the following linked list
	            5 -> 10 -> 19 -> 28
	            |    |     |     |
	            V    V     V     V
	            7    20    22    35
	            |          |     |
	            V          V     V
	            8          50    40
	            |                |
	            V                V
	            30               45
	        */
	 
	        L.head = L.push(L.head, 30);
	        L.head = L.push(L.head, 8);
	        L.head = L.push(L.head, 7);
	        L.head = L.push(L.head, 5);
	 
	        L.head.next = L.push(L.head.next, 20);
	        L.head.next = L.push(L.head.next, 10);
	 
	        L.head.next.next = L.push(L.head.next.next, 50);
	        L.head.next.next = L.push(L.head.next.next, 22);
	        L.head.next.next = L.push(L.head.next.next, 19);
	 
	        L.head.next.next.next = L.push(L.head.next.next.next, 45);
	        L.head.next.next.next = L.push(L.head.next.next.next, 40);
	        L.head.next.next.next = L.push(L.head.next.next.next, 35);
	        L.head.next.next.next = L.push(L.head.next.next.next, 20);
	 
	        // flatten the list
	        L.head = L.flatten(L.head);
	 
	        L.printList();
	    }
}
