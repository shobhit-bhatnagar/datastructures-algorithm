package linkedlist;

import util.Node;

public class ReverseAlternateKSublist {

	
	public Node<Integer> reverseKAlternateList(Node<Integer> node,int k)
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
		count =0;
		
		//skip next k 1,2,3,4,5,6,7,8,9
		if(node !=null)
		{
			node.next = current;
		}
		while(count <k && current!=null )
		{
			
			temp = current;
			current = current.next;
			count++;
		}
		next = current;
		if(next != null)
		{
			
			// this is important snippet as this implies next of head will point to k+1th node if exists otherwise null;
			temp.next = reverseKAlternateList(next, k);
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
	        
	        
	        ReverseAlternateKSublist rk = new ReverseAlternateKSublist();
	        

	        
	        System.out.println("Original Linked list ");
	        list.printList(list.head);
	        Node<Integer> res =	rk.reverseKAlternateList(list.head, 2);
	        System.out.println("");
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        list.printList(res);
	        
	}
}
