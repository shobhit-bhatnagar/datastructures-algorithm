package linkedlist;

import util.Node;

public class SplitList {

	
	public Node<Integer> Split(Node<Integer> head)
	{
		Node<Integer> current = head;
		Node<Integer> list2 = current.next;
		
		Node<Integer> next = current.next;
		
		while(current != null && next !=null)
		{
			current.next = next.next;
			current = next;
			next = current.next;
		}
		
		return list2;
	}
	
	public static void main(String [] args)
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
	        
	        Node<Integer> newHEad = new SplitList().Split(list.head);
	        list.printList(list.head);
	        
	        list.printList(newHEad);
	        
	}
}
