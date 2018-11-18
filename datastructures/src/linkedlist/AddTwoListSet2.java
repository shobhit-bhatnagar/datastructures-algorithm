package linkedlist;

import util.Node;

public class AddTwoListSet2 {

	/*
	 * representation
	 * 
	 * 1-2-3 => 123 2-3-1 =>231
	 * 
	 * 4213 221
	 */
	Node<Integer> result = null;
	int carry = 0;
	Node<Integer> curr = null;

	public void  addLists(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null) {
			return ;
		}
		if (head2 == null) {
			return ;
		}

		Node<Integer> n1 = head1;
		Node<Integer> n2 = head2;

		int m = 0;
		int n = 0;
		// count nodes

		while (n1 != null) {
			n1 = n1.next;
			m++;
		}
		while (n2 != null) {
			n2 = n2.next;
			n++;
		}

		n1 = head1;
		n2 = head2;
		if (m == n) {
			add(head1, head2);
		}

		else {
			int diff = m > n ? (m - n) : (n - m);
			if (n > m) {
				// swap nodes
				Node<Integer> temp = head1;
				head1 = head2;
				head2 = temp;
			}

			Node<Integer> temp = head1;
			while (diff >= 0) {
				curr = temp;
				temp = temp.next;
				diff--;
			}

			add(curr, head2);
			propagateCarry(head1);

		}
		if (carry > 0) {
			addToBeggining(carry);
		}
		
	}

	private void propagateCarry(Node<Integer> head1) {

		if (head1 != curr) {
			propagateCarry(head1.next);
			int sum = carry + head1.data;
			carry = sum / 10;
			sum = sum % 10;
			addToBeggining(sum);

		}

	}

	private Node<Integer> add(Node<Integer> head1, Node<Integer> head2) {

		if (head1 == null) {
			return null;
		}
		add(head1.next, head2.next);

		int sum = head1.data + head2.data + carry;
		carry = sum / 10;
		sum = sum % 10;

		addToBeggining(sum);
		return result;
	}

	private void addToBeggining(int sum) {
		Node<Integer> node = new Node<Integer>(sum);
		if (result == null) {
			result = node;
		} else {
			node.next = result;
			result = node;
		}

	}

	public static void main(String[] args) {
		ReverseList list = new ReverseList();

		list.head = new Node<Integer>(9);
		list.head.next = new Node<Integer>(9);

		ReverseList l2 = new ReverseList();
		l2.head = new Node<Integer>(1);

		AddTwoListSet2 atl = new AddTwoListSet2();

		atl.addLists(list.head, l2.head);

	}
}
