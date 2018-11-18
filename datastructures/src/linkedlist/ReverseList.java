package linkedlist;

import util.Node;

public class ReverseList {

	
	public Node<Integer> head;
	public Node<Integer> reverse(Node<Integer> head)
	{
		
		if(head == null || head.next == null)
		{
			return head;
		}
		
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		
		Node<Integer> temp = null;
		
		while(curr !=null)
		{
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		Node<Integer> newHead = prev;
		
		return newHead;
	}
	
	public Node<Integer> reverseRecur(Node<Integer> head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		Node<Integer> revHead = reverseRecur(head.next);
		
		head.next.next = head;
		
		head.next = null;
		
		return revHead;
	}
	
    // prints content of double linked list
    void printList(Node<Integer> node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public  Node<Integer> recDeleteDuplicates(Node<Integer> A)
    {
        if(A == null)
        {
            return A;
        }
        Node<Integer> head = A;
        Node<Integer> newHead = A;
        while(head.next!=null && head.data == head.next.data)
        {
            head = head.next;
        }

        if(A!=head)
        {
        	return (recDeleteDuplicates(head.next));
        }
        else
        {
        	head.next = recDeleteDuplicates(head.next);
        	return head;
        }
       
        
    }
	
	public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.head = new Node<Integer>(1);
        list.head.next = new Node<Integer>(2);
        list.head.next.next = new Node<Integer>(2);
        list.head.next.next.next = new Node<Integer>(4);
        list.head.next.next.next.next = new Node<Integer>(4);
        list.head.next.next.next.next.next = new Node<Integer>(6);
        list.head.next.next.next.next.next.next = new Node<Integer>(7);
        list.head.next.next.next.next.next.next.next = new Node<Integer>(8);
 
     
        
        System.out.println("Original Linked list ");
        list.printList(list.head);

        Node<Integer> t =  list.recDeleteDuplicates(list.head);
        list.printList(list.head);
        Node<Integer> res = list.reverse(list.head);
        System.out.println("");
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(res);
        

        res = list.reverseRecur(res);
        System.out.println("");
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(res);
    }
}
