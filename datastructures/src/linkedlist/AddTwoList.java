package linkedlist;

import util.Node;

public class AddTwoList {

	
	
	public Node<Integer> addList(Node<Integer> head1, Node<Integer> head2)
	{
		
		// 1--2--4  means 4 2 1   75946 84    
		
		/*64957
		 *   48
		 *     65005
		 */
		int carry = 0;
		int sum =0;
		Node<Integer> res = null;
		Node<Integer> prev = null;
		Node<Integer> temp = null;
		while(head1 != null || head2 !=null)
		{
			
			sum = carry + (head1!=null?head1.data:0) + (head2 != null ? head2.data:0); 
			if(sum >= 10)
			{
				 carry = sum/10;
			}
			else
			{
				carry=0;
			}
			sum=sum%10;
			temp = new Node<Integer>(sum);
			
			if(res == null)
			{
				res = temp;
			}
			else
			{
				prev.next = temp;
			}
			prev = temp;
			head1 = head1!=null? head1.next :null;
			head2 = head2!=null?head2.next:null;
		}
		
		if(carry >0)
		{
			temp.next = new Node<Integer>(carry);
		}
		return res;
		
	}
	
	 public static void main(String[] args) {
	        ReverseList list = new ReverseList();
	 
	        // creating first list
	        list.head = new Node<Integer>(7);
	        list.head.next = new Node<Integer>(5);
	        list.head.next.next = new Node<Integer>(9);
	        list.head.next.next.next = new Node<Integer>(4);
	        list.head.next.next.next.next = new Node<Integer>(6);
	        System.out.print("First List is ");
	        list.printList(list.head);
	 
	        // creating seconnd list
	        ReverseList list2 = new ReverseList();
	        list2.head = new Node<Integer>(8);
	        list2.head.next = new Node<Integer>(4);
	        System.out.print("Second List is ");
	        list.printList(list2.head);
	 
	        // add the two lists and see the result
	        Node<Integer> rs = new AddTwoList().addList(list.head, list2.head);
	        System.out.print("Resultant List is ");
	        list.printList(rs);
	    }
}
