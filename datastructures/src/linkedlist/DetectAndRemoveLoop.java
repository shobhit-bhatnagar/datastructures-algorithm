package linkedlist;

import util.Node;

public class DetectAndRemoveLoop {

	
	public void detectAndRemove(Node<Integer> node)
	{
		
		if(node == null || node.next == null)
		{
			return;
		}
		
		Node<Integer> current = node;
		Node<Integer> next = node.next;;
		while(current != null && next !=null && next.next !=null)
		{
			if(current == next)
			{
				break;
			}
			current = current.next;
			next = next.next.next;
		}
		if(next == null)
		{
			return;
		}
		
		removeCycle(next,node);
	}

	private void removeCycle(Node<Integer> loop, Node<Integer> node) {
		
		// first step find length of cycle
		
		int k =1;
		Node<Integer> ptr1 = loop;
		Node<Integer> ptr2 = loop;
		while(ptr1.next!=ptr2)
		{
			ptr1 = ptr1.next;
			k++;
		}
		
		
		ptr1 = node;
		ptr2 = node;
		while(k>0)
		{
			ptr2=ptr2.next;
			k--;
		}
		
		// lets go to the beginning of loop
		while(ptr1 != ptr2)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		// ptr2 is start of loop
		
		ptr2 = ptr2.next;
		while(ptr2.next != ptr1)
		{
			ptr2 = ptr2.next;
		}
		ptr2.next = null;
		
		
	}
	
	public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.head = new Node<Integer>(50);
        list.head.next = new Node<Integer>(20);
        list.head.next.next = new Node<Integer>(15);
        list.head.next.next.next = new Node<Integer>(4);
        list.head.next.next.next.next = new Node<Integer>(10);
 
        // Creating a loop for testing 
        list.head.next.next.next.next.next = list.head.next.next;
        new DetectAndRemoveLoop().detectAndRemove(list.head);
        System.out.println("Linked List after removing loop : ");
        list.printList(list.head);
	}
}
