package linkedlist;

import util.Node;

public class ReverseKSublist {

	public Node<Integer> reverseKList(Node<Integer> node,int k)
	{
		Node<Integer> current = node;
		Node<Integer> prev = null;
		Node<Integer> next = null;
		Node<Integer> temp = null;
		
		int count =0;
		// 1,2,3,4,5,6,7
		// 0  [1]  1 [2 1 ]  2 [3 1]
		while (count<k && current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
			count++;
		}
		
		next = current;
		if(next != null)
		{
			
			// this is important snippet as this implies next of head will point to k+1th node if exists otherwise null;
			node.next = reverseKList(next, k);
		}
		
		return prev;
	}
	
	
	public static void main(String[] args)
	{
		  ReverseList list = new ReverseList();
	        list.head = new Node<Integer>(1);
	        list.head.next = new Node<Integer>(2);
	        list.head.next.next = new Node<Integer>(3);
	        list.head.next.next.next = new Node<Integer>(4);
	        list.head.next.next.next.next = new Node<Integer>(5);
	        list.head.next.next.next.next.next = new Node<Integer>(6);
	        list.head.next.next.next.next.next.next = new Node<Integer>(7);
	        list.head.next.next.next.next.next.next.next = new Node<Integer>(8);
	        
	        
	        ReverseKSublist rk = new ReverseKSublist();
	        

	        
	        System.out.println("Original Linked list ");
	        list.printList(list.head);
	        Node<Integer> res =	rk.reverseKList(list.head, 3);
	        System.out.println("");
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        list.printList(res);
	        
	}
}
