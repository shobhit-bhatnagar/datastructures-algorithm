package linkedlist;

import util.Node;

public class MergeSortLinkedList {

	
	
	public Node<Integer> getMiddle(Node<Integer> node)
	{
		Node<Integer> slow = node;
		
		Node<Integer> fast = node.next;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public Node<Integer> mergeSort(Node<Integer> node)
	{
		if(node == null || node.next == null)
		{
			return node;
		}
		
		Node<Integer> middle = getMiddle(node);
		
		Node<Integer> middlenext = middle.next;
		middle.next = null;
		Node<Integer> leftNode = mergeSort(node);
		Node<Integer> rightNode = mergeSort(middlenext);
		
		Node<Integer> sortedHead = mergeSortedList(leftNode,rightNode);
		return sortedHead;
	}

	private Node<Integer> mergeSortedList(Node<Integer> leftNode, Node<Integer> rightNode) {
		
		if(leftNode == null)
		{
			return rightNode;
		}
		if(rightNode == null)
		{
			return leftNode;
		}
		Node<Integer> result = null;
		
		if(leftNode.data<rightNode.data)
		{
			result = leftNode;
			result.next = mergeSortedList(leftNode.next, rightNode);
		}
		
		else
		{
			result = rightNode;
			result.next = mergeSortedList(leftNode, rightNode.next);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) 
    {
		 ReverseList list = new ReverseList();
	        list.head = new Node<Integer>(7);
	        list.head.next = new Node<Integer>(4);
	        list.head.next.next = new Node<Integer>(6);
	        list.head.next.next.next = new Node<Integer>(2);
	        list.head.next.next.next.next = new Node<Integer>(5);
	        list.head.next.next.next.next.next = new Node<Integer>(3);
	        list.head.next.next.next.next.next.next = new Node<Integer>(8);
	        list.head.next.next.next.next.next.next.next = new Node<Integer>(1);
        System.out.println("Linked List without sorting is :");
        list.printList(list.head);
 
        // Apply merge Sort
        list.head = new MergeSortLinkedList().mergeSort(list.head);
        System.out.print("\n Sorted Linked List is: \n");
        list.printList(list.head);
    }
}
